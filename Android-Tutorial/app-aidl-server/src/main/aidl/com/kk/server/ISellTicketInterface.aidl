// ISellTicketInterface.aidl
package com.kk.server;
import com.kk.server.Ticket;
// Declare any non-default types here with import statements

interface ISellTicketInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    /**
     *生成火车票. inout:是双向通信
     */
    Ticket generateTicket(inout Ticket ticket);
}
