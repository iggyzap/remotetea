package org.acplt.oncrpc.apps.jrpcgen.cup_runtime;

/**
 * Defines the Scanner interface, which CUP uses in the default
 * implementation of <code>lr_parser.scan()</code>.  Integration
 * of scanners implementing <code>Scanner</code> is facilitated.
 *
 * @version last updated 23-Jul-1999
 * @author David MacMahon {@literal <davidm@smartsc.com>}
 */

/* *************************************************
  Interface Scanner
  
  Declares the next_token() method that should be
  implemented by scanners.  This method is typically
  called by lr_parser.scan().  End-of-file can be
  indicated either by returning
  <code>new Symbol(lr_parser.EOF_sym())</code> or
  <code>null</code>.
 ***************************************************/
public interface Scanner {
    /** 
     * Delivers the next token.
     * 
     * @return The next token, or <code>null</code> on end-of-file.
     * 
     * @throws Exception if any error occurs.
     */
    public Symbol next_token() throws java.lang.Exception;
}