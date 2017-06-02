package Helpers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "IPAddress")
public class IPAddress {

    @XmlElement
    public String ip;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public IPAddress(){

    }

    public IPAddress(String ip){
        this.ip=ip;
    }
}
