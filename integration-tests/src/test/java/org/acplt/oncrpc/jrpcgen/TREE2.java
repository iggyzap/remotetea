/*
 * Automatically generated by jrpcgen 1.1.1 on 30.01.15 12:25
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
package org.acplt.oncrpc.jrpcgen;
import org.acplt.oncrpc.*;
import java.io.IOException;

public class TREE2 implements XdrAble {
    public String key;
    public String value;
    public TREE2 left;
    public TREE2 right;

    public TREE2() {
    }

    public TREE2(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        TREE2 $this = this;
        do {
            xdr.xdrEncodeString($this.key);
            xdr.xdrEncodeString($this.value);
            if ( $this.left != null ) { xdr.xdrEncodeBoolean(true); $this.left.xdrEncode(xdr); } else { xdr.xdrEncodeBoolean(false); };
            $this = $this.right;
            xdr.xdrEncodeBoolean($this != null);
        } while ( $this != null );
    }

    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        TREE2 $this = this;
        TREE2 $next;
        do {
            $this.key = xdr.xdrDecodeString();
            $this.value = xdr.xdrDecodeString();
            $this.left = xdr.xdrDecodeBoolean() ? new TREE2(xdr) : null;
            $next = xdr.xdrDecodeBoolean() ? new TREE2() : null;
            $this.right = $next;
            $this = $next;
        } while ( $this != null );
    }

}
// End of TREE2.java
