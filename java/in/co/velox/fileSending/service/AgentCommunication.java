package in.co.velox.fileSending.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AgentCommunication {

    DataOutputStream dous = null;
    DataInputStream dis = null;
    String ip;
    int port;
    boolean newRequest;
    String branch_name;
    boolean handShake = false;
    boolean isReconnecting = false;
    boolean requestFirstConnect = false;
    boolean isConnected = false;
    boolean initialize = false;
    int port_no = 8002;
    String requestStr = null;
    Socket s = null;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        AgentCommunication c = new AgentCommunication("192.168.0.33", 8002);

        String res = c.requestFor("INSTALL_APP=C");
        System.out.println("res:" + res);
    }

    public AgentCommunication(String ip, int port_no) {
        this.ip = ip;
        this.port_no = port_no;
    }

    private String connectToServer() {
        String query = "";
        String natip = "";
        String status="ERROR";
        System.out.println("ip_Address@@@@" + ip);
        System.out.println("port!!!!!" + port_no);
        try {
         //   try {
//                con = Datasource.getConnection();
//                query = "SELECT NAT_IPADDRESS FROM IP_MAPPING WHERE ALL_IPADDRESS='" + ip + "'";
//
//                pst = con.prepareStatement(query);
//                rs = pst.executeQuery();
//                while (rs.next()) {
//                    ip = rs.getString(1);
//
//                }
//            } catch (Exception e) {
//                System.out.println("[ERROR IN NAT IP] " + e);
//            }
            isReconnecting = true;
            System.out.println(String.format("[INFO] Connecting to %s : %s health server port  ", ip, port_no));
            if (s != null) {
                s.close();
            }
            
            s = new Socket(ip, port_no);
          
            s.setSoTimeout(1000 * 60 * 2);
            handShake = true;
            this.dous = new DataOutputStream(s.getOutputStream());
            this.dis = new DataInputStream(s.getInputStream());
            System.out.println("[INFO] ***Connected to  " + ip + "****");
            isReconnecting = false;
            status="Success";
        } catch (Exception e) {
            System.out.println("[ERROR]  Communication to server connection " + e);
            System.out.println(e.toString());
            initialize = false;
            status="clientfail";
        }
return status;
    }

    public String requestFor(String resquetsStr) {

        
        
        try {
            boolean mainloop = true;
            System.out.println("[INFO] Health Server [" + ip + "]");
            String str=null;
            try {
                // requesting init1523

                str=connectToServer();
                dous.writeUTF(resquetsStr);
                dous.flush();
                Thread.sleep(1000);
                 str = (String) dis.readUTF();
                System.out.println("" + str);

                System.out.println("[INFO]  Reponce from server " + str);
                flushConnection();
          
                return str;

            } catch (Exception e) {
                System.out.println("[Error] (" + ip + ") Client disconnected , will retry in 60000 ms [" + e + "}");
                isConnected = false;
                try {
                    if (s != null) {
                        s.close();
                    }

                } catch (Exception er) {

                    System.out.println("" + er);
                }
                return str;
            }

        } catch (Exception e) {
            System.out.println("[Error ] Disconnected ");
            //  ArgServer.printLog("command send error: " + e.toString());
        }

        return "ERROR";
    }

    public JSONArray setRequest(String rqst) {

        try {
            if (dous == null) {
                System.out.println("[INFO] blank inputsteam trying to reconnect");

                if (isReconnecting) {

                    System.out.println("[INFO] reconnection is in progress. [" + rqst + "] Request is skipped.");
                } else {
                    connectToServer();
                }
                // return new JSONArray();
            }
            if (isConnected) {

                synchronized (this) {

                    dous.writeUTF(rqst);
                    // dous.flush();
                    String rsp = dis.readUTF();
                    return parseServerReponseString(rsp);
                }
            }

        } catch (Exception e) {
            isConnected = false;
            initialize = false;
            System.out.println("[ERROR] " + this.getClass() + " setRequest :" + e);
            System.out.println("[INFO] trying to reconnect ");
            connectToServer();
            //e.printStackTrace();
            //  System.out.println(" error " + e);
        }
        // } else {
        //      return new JSONArray();
        //  }
        return new JSONArray();
    }

    private void processResponce(String rsp) {
        try {

            // if request is for the initialization the only send the acknowledg
            if (rsp.contentEquals("test")) {
                changeStatus("ON");
                System.out.println("[Info] (" + ip + ") Client is connected");
                // first request 
                newRequest = checkRequest();

                if (newRequest) {
                    dous.writeUTF("test");

                }

            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    public void changeStatus(String status) {
    }

    public void setResponse(String rqst) {
        try {
            dous.writeUTF(rqst);
        } catch (Exception e) {
            System.out.println(" error " + e);
        }
    }

    public JSONArray parseServerReponseString(String serverResponce) {

        JSONArray rqstResponse = null;
        // System.out.println(" server ATM-> " + serverResponce);
        try {
            if (serverResponce.contentEquals("ERROR")) {
                rqstResponse = new JSONArray();
                JSONObject resObj = new JSONObject();
                resObj.put("response", "error");
                rqstResponse.put(resObj);
            } else {
                rqstResponse = new JSONArray(serverResponce);

            }

        } catch (Exception e) {
            System.out.println("[ERROR] responce from server agent " + e);
            //  e.printStackTrace();;
            JSONObject resObj = new JSONObject();
            rqstResponse = new JSONArray();
            try {
                resObj.put("response", "error");
                rqstResponse.put(resObj);
            } catch (JSONException ex) {
                System.out.println(e);

                // Logger.getLogger(CommunicationServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rqstResponse;
    }

    private boolean checkRequest() {

        return true;
    }

    private void flushConnection() {
        try {
            if (dous != null) {
                dous.flush();
            }
            if (dis != null) {
                dis.close();
            }

            if (s != null) {

                s.close();
            }
            Thread.sleep(50);

        } catch (Exception er) {
            System.out.println("[ERROR] Connection flushing " + er);
        }
        isConnected = false;
    }

}
