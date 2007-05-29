/*
 * Automatically generated by jrpcgen 1.0.7 on 29.05.07 21:17
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
package tests.org.acplt.oncrpc.jrpcgen;
import org.acplt.oncrpc.*;
import java.io.IOException;

public class STRING implements XdrAble, java.io.Serializable {

    public String value;

    private static final long serialVersionUID = -5513160560686984193L;

    public STRING() {
    }

    public STRING(String value) {
        this.value = value;
    }

    public STRING(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        xdr.xdrEncodeString(value);
    }

    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        value = xdr.xdrDecodeString();
    }

}
// End of STRING.java
