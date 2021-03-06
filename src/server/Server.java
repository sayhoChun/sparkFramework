package server;

import server.services.ServiceIgniter;

/**
 * @author Euijin.Ham
 * @version 1.0.0
 * A Main Entrance Class for igniting both of communication server and service server
 * Jul-21-2017
 */
public class Server {

    public static void main(String... args){
        /**
         * Service Server Ignition
         */
        ServiceIgniter.getInstance().igniteServiceServer();
    }

}