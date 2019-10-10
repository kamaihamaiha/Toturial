/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.kk.server;
// Declare any non-default types here with import statements

public interface ISellTicketInterface extends android.os.IInterface
{
  /** Default implementation for ISellTicketInterface. */
  public static class Default implements com.kk.server.ISellTicketInterface
  {
    /**
         * Demonstrates some basic types that you can use as parameters
         * and return values in AIDL.
         */
    @Override public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException
    {
    }
    /**
         *生成火车票. inout:是双向通信
         */
    @Override public com.kk.server.Ticket generateTicket(com.kk.server.Ticket ticket) throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.kk.server.ISellTicketInterface
  {
    private static final java.lang.String DESCRIPTOR = "com.kk.server.ISellTicketInterface";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.kk.server.ISellTicketInterface interface,
     * generating a proxy if needed.
     */
    public static com.kk.server.ISellTicketInterface asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.kk.server.ISellTicketInterface))) {
        return ((com.kk.server.ISellTicketInterface)iin);
      }
      return new com.kk.server.ISellTicketInterface.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_basicTypes:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          long _arg1;
          _arg1 = data.readLong();
          boolean _arg2;
          _arg2 = (0!=data.readInt());
          float _arg3;
          _arg3 = data.readFloat();
          double _arg4;
          _arg4 = data.readDouble();
          java.lang.String _arg5;
          _arg5 = data.readString();
          this.basicTypes(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_generateTicket:
        {
          data.enforceInterface(descriptor);
          com.kk.server.Ticket _arg0;
          if ((0!=data.readInt())) {
            _arg0 = com.kk.server.Ticket.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          com.kk.server.Ticket _result = this.generateTicket(_arg0);
          reply.writeNoException();
          if ((_result!=null)) {
            reply.writeInt(1);
            _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          }
          else {
            reply.writeInt(0);
          }
          if ((_arg0!=null)) {
            reply.writeInt(1);
            _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          }
          else {
            reply.writeInt(0);
          }
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.kk.server.ISellTicketInterface
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
           * Demonstrates some basic types that you can use as parameters
           * and return values in AIDL.
           */
      @Override public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(anInt);
          _data.writeLong(aLong);
          _data.writeInt(((aBoolean)?(1):(0)));
          _data.writeFloat(aFloat);
          _data.writeDouble(aDouble);
          _data.writeString(aString);
          boolean _status = mRemote.transact(Stub.TRANSACTION_basicTypes, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().basicTypes(anInt, aLong, aBoolean, aFloat, aDouble, aString);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /**
           *生成火车票. inout:是双向通信
           */
      @Override public com.kk.server.Ticket generateTicket(com.kk.server.Ticket ticket) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.kk.server.Ticket _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((ticket!=null)) {
            _data.writeInt(1);
            ticket.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_generateTicket, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().generateTicket(ticket);
          }
          _reply.readException();
          if ((0!=_reply.readInt())) {
            _result = com.kk.server.Ticket.CREATOR.createFromParcel(_reply);
          }
          else {
            _result = null;
          }
          if ((0!=_reply.readInt())) {
            ticket.readFromParcel(_reply);
          }
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.kk.server.ISellTicketInterface sDefaultImpl;
    }
    static final int TRANSACTION_basicTypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_generateTicket = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static boolean setDefaultImpl(com.kk.server.ISellTicketInterface impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.kk.server.ISellTicketInterface getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
       * Demonstrates some basic types that you can use as parameters
       * and return values in AIDL.
       */
  public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException;
  /**
       *生成火车票. inout:是双向通信
       */
  public com.kk.server.Ticket generateTicket(com.kk.server.Ticket ticket) throws android.os.RemoteException;
}
