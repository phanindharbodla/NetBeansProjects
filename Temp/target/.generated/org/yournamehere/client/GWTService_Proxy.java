package org.yournamehere.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class GWTService_Proxy extends RemoteServiceProxy implements org.yournamehere.client.GWTServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.yournamehere.client.GWTService";
  private static final String SERIALIZATION_POLICY ="5FF60F9373816F5E4234304AC0D1678C";
  private static final org.yournamehere.client.GWTService_TypeSerializer SERIALIZER = new org.yournamehere.client.GWTService_TypeSerializer();
  
  public GWTService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "gwtservice", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void addMessage(java.lang.String s, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GWTService_Proxy.addMessage", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("addMessage");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(s);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GWTService_Proxy.addMessage", requestId, "requestSerialized"));
      doInvoke(ResponseReader.VOID, "GWTService_Proxy.addMessage", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getMessages(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("GWTService_Proxy.getMessages", requestId, "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("getMessages");
      streamWriter.writeInt(0);
      String payload = streamWriter.toString();
      toss = isStatsAvailable() && stats(timeStat("GWTService_Proxy.getMessages", requestId, "requestSerialized"));
      doInvoke(ResponseReader.OBJECT, "GWTService_Proxy.getMessages", requestId, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
