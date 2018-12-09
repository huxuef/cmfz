package com.baizhi.cmfz.log;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;
import org.apache.log4j.Logger;

public class TestLog {
    private static Logger logger = Logger.getLogger(TestLog.class);

    public static void main(String[] args) throws InterruptedException, EventDeliveryException {
        RpcClient client = RpcClientFactory.getDefaultInstance("CentOS", 44444);
        for (int i = 0; i < 10; i++) {

            Event event = EventBuilder.withBody(("value"+i).getBytes());
            event.getHeaders().put("key", "value");
            client.append(event);
        }
        client.close();




    }
}
