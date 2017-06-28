package com.jmr.hanvonkao.server;


import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import com.hanvon.faceid.sdk.FaceId_Item;
import com.hanvon.faceid.sdk.ISocketServerThreadTask;
import com.hanvon.faceid.sdk.NetworkStreamPlus;
import com.hanvon.faceid.sdk.TcpListenerPlus;
import com.jmr.model.Hanvondevice;
import com.jmr.service.impl.HanvondeviceService;
import com.jmr.service.impl.HanvonkaoService;
import javafx.application.Platform;
import javafx.fxml.Initializable;


public class SpringhwController implements Initializable, ISocketServerThreadTask {
    
    private final String DeviceCharset = "GBK";
    
    private boolean IsServerRunning = false;
    
    public TcpListenerPlus TcpServer = null;
 

    public void startListenerAction() throws IOException, Exception {
        if(IsServerRunning)
        {
            if(TcpServer != null)
            {
                TcpServer.close();
                TcpServer = null;
            }
            IsServerRunning = false;
            System.out.println("1111");
        }
        else
        {   
            //InetAddress address=InetAddress.getByName("141.146.8.66");  
            TcpServer = new TcpListenerPlus(9920);
          
            //System.out.println("1111");
            // 鐠佸墽鐤嗛柅姘繆缁捐法鈻兼禒璇插婵梹澧�
            TcpServer.ThreadTaskDelegate = this;
            
            // 瀵拷閸氼垯鐫涢崥顒佹箛閸旓拷
            TcpServer.StartListenThread(null, 0, 0);
            System.out.println("1111");
            IsServerRunning = true;
        
        }
    }
    
    @Override
    public void OnServerTaskRequest(NetworkStreamPlus stream)  {
        // 鐠佹儳顦悧瑙勭暕闁矮淇婄�靛棛鐖�
        // stream.setSecretKey(textFieldSecretKey.getText());  // 濞夈劍鍓伴敍姘槕閻浇顩﹂崪宀冾啎婢跺洭锟芥矮淇婄�靛棛鐖滄稉锟介懛锟�
    	
        String SerialNumber = null; 
        String institut_id;
        String class_id;
        String student_id;
        String name;
        String time;
        
        while(true)
        {   
        	
        	try {
                // 鐠囪褰囬弫鐗堝祦
                String Answer = stream.Read(DeviceCharset);
                
                // 閺勫墽銇氱拠璇插絿娣団剝浼�
               // Platform.runLater(() -> {
                    System.out.println(Answer + "\r\n");
              //  });
                
                if(Answer.startsWith("PostRecord"))
                {   // 閹绘劕褰囨惔蹇撳灙閸欏嘲鑻熸穱婵嗙摠
                    SerialNumber = FaceId_Item.GetKeyValue(Answer, "sn");
                    
                   
                        stream.Write("Return(result=\"success\" postphoto=\"false\")", DeviceCharset);
                  //  }
                }
                else if(Answer.startsWith("Record"))
                {  
                	//HanvonController hwsc=new HanvonController();
                   // List<Hanvondevice> hws=ihwdev.list();
                	System.out.println("ddddddddddd");
                	HanvondeviceService obj=(HanvondeviceService)SpringUtil.getObject("hanvondeviceService");                     	
                	Hanvondevice ppoo=obj.getOne(SerialNumber);
                    System.out.println("ddddddddddd"+ppoo.getGateip());
                   institut_id=ppoo.getInstitutHao();
                   class_id=ppoo.getClassId();
                   student_id=FaceId_Item.GetKeyValue(Answer, "id");
                   name=FaceId_Item.GetKeyValue(Answer, "name");
                   time=FaceId_Item.GetKeyValue(Answer, "time");
                 
                   HanvonkaoService obj1=(HanvonkaoService)SpringUtil.getObject("hanvonkaoService");         
                   obj1.insertOne(0, institut_id, class_id, student_id, name, time);
                    stream.Write("Return(result=\"success\")", DeviceCharset);
                }
                else if(Answer.startsWith("PostEmployee"))
                {   // 閸戝棗顦稉濠佺炊娴滃搫鎲虫穱鈩冧紖
                    
                    // 閺堝秴濮熼崳銊ユ礀鎼达拷
                    stream.Write("Return(result=\"success\")", DeviceCharset);
                }                
                else if(Answer.startsWith("Employee"))
                {   // 鐠囪褰囨禍鍝勬喅娣団剝浼�
                    
                    // 閺堝秴濮熼崳銊ユ礀鎼达拷
                    stream.Write("Return(result=\"success\")", DeviceCharset);
                }
                else if (Answer.startsWith("GetRequest"))
                {   // 娑撳褰傞崨鎴掓姢
                    Platform.runLater(() -> {
                       
                      
                    });
                }
                else if(Answer.startsWith("Quit"))
                {   // 缂佹挻娼导姘崇樈
                    break;
                }
            }
            catch (Exception ex)
            {
                break;  // 鏉╃偞甯撮弬顓炵磻
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 鐠佸墽鐤嗛張宥呭閸ｃ劌婀撮崸锟�
        try
        {
            List<String> IPList = new LinkedList<>();
            Enumeration<NetworkInterface> InterfaceList = NetworkInterface.getNetworkInterfaces();
            while (InterfaceList.hasMoreElements())
            { 
                NetworkInterface iFace = InterfaceList.nextElement();
                if(iFace.isLoopback() || iFace.isVirtual() || iFace.isPointToPoint() || !iFace.isUp()) continue;
                                
                Enumeration<InetAddress> AddrList = iFace.getInetAddresses(); 
                while (AddrList.hasMoreElements())
                { 
                    InetAddress address = AddrList.nextElement(); 
                    if ((address instanceof Inet4Address) || (address instanceof Inet6Address))
                    {
                        IPList.add(address.getHostAddress());                
                    }
                } 
            }
            
                   
        }
        catch (SocketException ex) 
        {
            // 瀵倸鐖舵径鍕倞
        }
    }
}
