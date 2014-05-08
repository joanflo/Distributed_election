
package server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "arrancaProcesos", namespace = "http://server/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrancaProcesos", namespace = "http://server/")
public class Hello {

    @XmlElement(name = "arrancaProcesos", namespace = "")
    private String arrancaProcesos;

    /**
     * 
     * @return
     *     returns String
     */
    public String getArrancaProcesos() {
        return this.arrancaProcesos;
    }

    /**
     * 
     * @param arrancaProcesos
     *     the value for the arrancaProcesos property
     */
    public void setArrancaProcesos(String arrancaProcesos) {
        this.arrancaProcesos = arrancaProcesos;
    }

}
