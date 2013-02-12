#include<iostream>
#define MAX 1000000
#define loop0(i,j) for(int i=0;i<j;i++)
#define loop1(i,j) for(int i=1;i<j;i++)
using namespace std;
bool flag[MAX] = {0};
int tree[MAX] = {0};

void update(long int node, long int b, long int e, long int i, long int j) {
    if (b > j || e < i) return;
    if (b >= i && e <= j) {
        if (flag[node]) {
            flag[node] = 0;
            return;
        } else {
            tree[node] = e - b + 1 - tree[node];

            flag[2 * node] = !flag[2 * node];
            flag[2 * node + 1] = !flag[2 * node + 1];

            return;
        }
    } else {
        if (flag[node]) {
            flag[node] = 0;
            flag[2 * node] = !flag[2 * node];
            flag[2 * node + 1] = !flag[2 * node + 1];
        }
        update(2 * node, b, (b + e) / 2, i, j);
        update(2 * node + 1, (b + e) / 2 + 1, e, i, j);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
        return;
    }
}

long int query(long int node, long int b, long int e, long int i, long int j) {
    long int l, r;

    if (b > j || e < i) return -1;

    if (b >= i && e <= j) {
        if (!flag[node])
            return tree[node];
        else {
            flag[node] = 0;
            tree[node] = e - b + 1 - tree[node];
            flag[2 * node] = !flag[2 * node];
            flag[2 * node + 1] = !flag[2 * node + 1];
            return tree[node];
        }
    } else {
        if (flag[node]) {
            flag[node] = 0;
            tree[node] = e - b + 1 - tree[node];
            flag[2 * node] = !flag[2 * node];
            flag[2 * node + 1] = !flag[2 * node + 1];
        }
        l = query(2 * node, b, (b + e) / 2, i, j);
        r = query(2 * node + 1, (b + e) / 2 + 1, e, i, j);
        if (l == -1 & r == -1)
            return tree[node];
        else if (l == -1) return r;
        else if (r == -1) return l;
        return (l + r);
    }
}

int main() {
    int k, t, tests, m, n;
    int f, a, b, z;
    scanf("%d %d", &tests, &m);

    loop0(i, m) {
        scanf("%d %d %d", &f, &a, &b);
        if (f == 0)
            update(1, 0, tests - 1, a, b);
        else
            printf("%d\n", query(1, 0, tests - 1, a, b));
    }
    return 0;
}
