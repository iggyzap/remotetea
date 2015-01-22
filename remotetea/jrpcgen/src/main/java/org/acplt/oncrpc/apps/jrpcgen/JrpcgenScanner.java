/* The following code was generated by JFlex 1.2.2 on 20.10.00 09:36 */

/*
 * $Header: /home/harald/repos/remotetea.sf.net/remotetea/src/org/acplt/oncrpc/apps/jrpcgen/JrpcgenScanner.java,v 1.1 2003/08/13 12:03:47 haraldalbrecht Exp $
 *
 * Copyright (c) 1999, 2000
 * Lehrstuhl fuer Prozessleittechnik (PLT), RWTH Aachen
 * D-52064 Aachen, Germany.
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Library General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this program (see the file COPYING.LIB for more
 * details); if not, write to the Free Software Foundation, Inc.,
 * 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 * To compile into java code use:
 *   java -jar <whereever/>JFlex.jar JrpcgenScanner.flex
 */

package org.acplt.oncrpc.apps.jrpcgen;
import org.acplt.oncrpc.apps.jrpcgen.cup_runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.informatik.tu-muenchen.de/~kleing/jflex/">JFlex</a> 1.2.2
 * on 20.10.00 09:36 from the specification file
 * <tt>file:/G:/JAVA/SRC/ORG/ACPLT/ONCRPC/APPS/JRPCGEN/JrpcgenScanner.flex</tt>
 */
class JrpcgenScanner implements org.acplt.oncrpc.apps.jrpcgen.cup_runtime.Scanner {

  /** this character denotes the end of file */
  final public static int YYEOF = -1;

  /** lexical states */
  final public static int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  final private static String yycmap_packed = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\7\0\1\63"+
    "\1\64\1\5\1\0\1\60\1\14\1\0\1\4\1\7\7\13\2\10"+
    "\1\61\1\57\1\71\1\62\1\72\2\0\1\34\3\12\1\37\1\12"+
    "\1\33\1\6\1\41\3\6\1\35\1\42\1\32\1\30\1\6\1\31"+
    "\1\40\2\6\1\36\4\6\1\67\1\0\1\70\1\0\1\54\1\0"+
    "\1\21\1\55\1\43\1\46\1\24\1\47\1\20\1\51\1\26\2\6"+
    "\1\53\1\22\1\27\1\17\1\15\1\56\1\16\1\25\1\44\1\52"+
    "\1\23\1\50\1\11\1\45\1\6\1\65\1\0\1\66\uff82\0";

  /** 
   * Translates characters to character classes
   */
  final private static char [] yycmap = yy_unpack_cmap(yycmap_packed);

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int yy_rowMap [] = { 
        0,    59,   118,    59,   177,    59,   236,   295,   354,   413, 
      472,   531,   590,   649,   708,   767,   826,   885,   944,  1003, 
     1062,  1121,  1180,  1239,  1298,  1357,  1416,    59,    59,    59, 
       59,    59,    59,    59,    59,    59,    59,    59,    59,  1475, 
     1534,  1593,  1652,  1711,  1770,  1829,  1888,  1947,  2006,  2065, 
     2124,  2183,  2242,  2301,  2360,  2419,  2478,  2537,  2596,  2655, 
     2714,  2773,  2832,  2891,  2950,  3009,  3068,  1475,  3127,  1652, 
     3186,  3245,  3304,  3363,  3422,  3481,  3540,  3599,   236,  3658, 
     3717,  3776,  3835,  3894,  3953,  4012,  4071,  4130,  4189,  4248, 
     4307,  4366,  4425,  4484,  4543,  4602,  4661,   236,  4720,   236, 
     4779,  4838,  4897,  4956,  5015,  5074,  5133,   236,   236,  5192, 
     5251,  5310,  5369,  5428,  5487,  5546,   236,  5605,  5664,  5723, 
     5782,  5841,  5900,  5959,  6018,   236,  6077,  6136,   236,  6195, 
     6254,  6313,   236,   236,  6372,   236,  6431,  6490,  6549,   236, 
     6608,   236,   236,   236,  6667,  6726,  6785,   236,  6844,  6903, 
      236,  6962,   236,   236,   236,   236,  7021,  7080,   236,  7139, 
      236
  };

  /** 
   * The packed transition table of the DFA
   */
  final private static String yy_packed = 
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\10\1\11"+
    "\2\7\1\11\1\12\1\13\1\7\1\14\3\7\1\15"+
    "\1\16\1\17\1\20\1\7\1\21\5\7\1\22\4\7"+
    "\1\23\1\24\1\7\1\25\1\26\1\7\1\27\1\30"+
    "\1\31\1\7\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
    "\75\0\1\4\74\0\1\50\1\51\73\0\6\7\1\0"+
    "\42\7\23\0\1\52\1\0\1\53\1\0\1\52\66\0"+
    "\2\11\2\0\1\11\67\0\1\11\2\0\1\11\65\0"+
    "\6\7\1\0\1\7\1\54\40\7\22\0\6\7\1\0"+
    "\1\55\41\7\22\0\6\7\1\0\2\7\1\56\4\7"+
    "\1\57\32\7\22\0\6\7\1\0\12\7\1\60\27\7"+
    "\22\0\6\7\1\0\27\7\1\61\3\7\1\62\1\63"+
    "\5\7\22\0\6\7\1\0\12\7\1\64\27\7\22\0"+
    "\6\7\1\0\14\7\1\65\25\7\22\0\6\7\1\0"+
    "\22\7\1\66\17\7\22\0\6\7\1\0\2\7\1\67"+
    "\1\7\1\70\27\7\1\71\5\7\22\0\6\7\1\0"+
    "\30\7\1\72\11\7\22\0\6\7\1\0\2\7\1\73"+
    "\4\7\1\74\32\7\22\0\6\7\1\0\36\7\1\75"+
    "\3\7\22\0\6\7\1\0\30\7\1\76\11\7\22\0"+
    "\6\7\1\0\12\7\1\77\24\7\1\100\2\7\22\0"+
    "\6\7\1\0\2\7\1\101\37\7\22\0\6\7\1\0"+
    "\2\7\1\102\37\7\22\0\6\7\1\0\35\7\1\103"+
    "\4\7\14\0\1\50\1\104\1\4\70\50\5\51\1\105"+
    "\65\51\7\0\1\52\3\0\1\52\66\0\2\106\1\0"+
    "\2\106\5\0\1\106\2\0\1\106\7\0\1\106\2\0"+
    "\1\106\3\0\1\106\2\0\2\106\5\0\1\106\23\0"+
    "\6\7\1\0\2\7\1\107\37\7\22\0\6\7\1\0"+
    "\4\7\1\110\35\7\22\0\6\7\1\0\11\7\1\111"+
    "\30\7\22\0\6\7\1\0\1\7\1\112\40\7\22\0"+
    "\6\7\1\0\35\7\1\113\4\7\22\0\6\7\1\0"+
    "\1\7\1\114\40\7\22\0\6\7\1\0\11\7\1\115"+
    "\30\7\22\0\6\7\1\0\2\7\1\116\37\7\22\0"+
    "\6\7\1\0\27\7\1\117\12\7\22\0\6\7\1\0"+
    "\15\7\1\120\24\7\22\0\6\7\1\0\14\7\1\121"+
    "\25\7\22\0\6\7\1\0\12\7\1\122\27\7\22\0"+
    "\6\7\1\0\10\7\1\123\31\7\22\0\6\7\1\0"+
    "\4\7\1\124\35\7\22\0\6\7\1\0\1\125\41\7"+
    "\22\0\6\7\1\0\35\7\1\126\4\7\22\0\6\7"+
    "\1\0\32\7\1\127\7\7\22\0\6\7\1\0\2\7"+
    "\1\130\37\7\22\0\6\7\1\0\1\131\41\7\22\0"+
    "\6\7\1\0\10\7\1\132\1\133\30\7\22\0\6\7"+
    "\1\0\10\7\1\134\1\20\24\7\1\31\3\7\22\0"+
    "\6\7\1\0\12\7\1\135\27\7\22\0\6\7\1\0"+
    "\2\7\1\136\37\7\22\0\6\7\1\0\4\7\1\137"+
    "\35\7\14\0\4\51\1\4\1\105\65\51\6\0\6\7"+
    "\1\0\3\7\1\140\36\7\22\0\6\7\1\0\41\7"+
    "\1\141\22\0\6\7\1\0\31\7\1\142\10\7\22\0"+
    "\6\7\1\0\10\7\1\143\31\7\22\0\6\7\1\0"+
    "\5\7\1\144\34\7\22\0\6\7\1\0\11\7\1\145"+
    "\23\7\1\146\4\7\22\0\6\7\1\0\27\7\1\147"+
    "\12\7\22\0\6\7\1\0\1\7\1\150\40\7\22\0"+
    "\6\7\1\0\16\7\1\151\23\7\22\0\6\7\1\0"+
    "\23\7\1\152\16\7\22\0\6\7\1\0\10\7\1\153"+
    "\31\7\22\0\6\7\1\0\7\7\1\154\32\7\22\0"+
    "\6\7\1\0\1\7\1\155\40\7\22\0\6\7\1\0"+
    "\7\7\1\156\32\7\22\0\6\7\1\0\40\7\1\157"+
    "\1\7\22\0\6\7\1\0\4\7\1\160\35\7\22\0"+
    "\6\7\1\0\4\7\1\161\35\7\22\0\6\7\1\0"+
    "\7\7\1\162\32\7\22\0\6\7\1\0\11\7\1\163"+
    "\30\7\22\0\6\7\1\0\2\7\1\164\37\7\22\0"+
    "\6\7\1\0\34\7\1\63\5\7\22\0\6\7\1\0"+
    "\3\7\1\165\36\7\22\0\6\7\1\0\36\7\1\166"+
    "\3\7\22\0\6\7\1\0\31\7\1\167\10\7\22\0"+
    "\6\7\1\0\1\7\1\170\40\7\22\0\6\7\1\0"+
    "\35\7\1\171\4\7\22\0\6\7\1\0\11\7\1\172"+
    "\30\7\22\0\6\7\1\0\12\7\1\173\27\7\22\0"+
    "\6\7\1\0\26\7\1\174\13\7\22\0\6\7\1\0"+
    "\26\7\1\175\13\7\22\0\6\7\1\0\27\7\1\176"+
    "\12\7\22\0\6\7\1\0\14\7\1\177\25\7\22\0"+
    "\6\7\1\0\24\7\1\200\15\7\22\0\6\7\1\0"+
    "\27\7\1\201\12\7\22\0\6\7\1\0\31\7\1\202"+
    "\10\7\22\0\6\7\1\0\36\7\1\203\3\7\22\0"+
    "\6\7\1\0\35\7\1\204\4\7\22\0\6\7\1\0"+
    "\27\7\1\205\12\7\22\0\6\7\1\0\1\7\1\206"+
    "\40\7\22\0\6\7\1\0\3\7\1\207\36\7\22\0"+
    "\6\7\1\0\12\7\1\210\27\7\22\0\6\7\1\0"+
    "\37\7\1\211\2\7\22\0\6\7\1\0\1\7\1\212"+
    "\40\7\22\0\6\7\1\0\4\7\1\213\35\7\22\0"+
    "\6\7\1\0\7\7\1\214\32\7\22\0\6\7\1\0"+
    "\2\7\1\215\37\7\22\0\6\7\1\0\3\7\1\216"+
    "\36\7\22\0\6\7\1\0\27\7\1\217\12\7\22\0"+
    "\6\7\1\0\34\7\1\220\5\7\22\0\6\7\1\0"+
    "\17\7\1\221\22\7\22\0\6\7\1\0\15\7\1\222"+
    "\24\7\22\0\6\7\1\0\7\7\1\223\32\7\22\0"+
    "\6\7\1\0\7\7\1\224\32\7\22\0\6\7\1\0"+
    "\36\7\1\225\3\7\22\0\6\7\1\0\12\7\1\226"+
    "\27\7\22\0\6\7\1\0\27\7\1\227\12\7\22\0"+
    "\6\7\1\0\35\7\1\230\4\7\22\0\6\7\1\0"+
    "\5\7\1\231\34\7\22\0\6\7\1\0\12\7\1\232"+
    "\27\7\22\0\6\7\1\0\20\7\1\231\21\7\22\0"+
    "\6\7\1\0\25\7\1\232\14\7\22\0\6\7\1\0"+
    "\32\7\1\233\7\7\22\0\6\7\1\0\27\7\1\234"+
    "\12\7\22\0\6\7\1\0\7\7\1\235\32\7\22\0"+
    "\6\7\1\0\1\236\41\7\22\0\6\7\1\0\31\7"+
    "\1\237\10\7\22\0\6\7\1\0\36\7\1\240\3\7"+
    "\22\0\6\7\1\0\7\7\1\241\32\7\14\0";

  /** 
   * The transition table of the DFA
   */
  final private static int yytrans [] = yy_unpack(yy_packed);


  /* error codes */
  final private static int YY_UNKNOWN_ERROR = 0;
  final private static int YY_ILLEGAL_STATE = 1;
  final private static int YY_NO_MATCH = 2;
  final private static int YY_PUSHBACK_2BIG = 3;

  /* error messages for the codes above */
  final private static String YY_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Internal error: unknown state",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * YY_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private final static byte YY_ATTRIBUTE[] = {
     0,  9,  1,  9,  1,  9,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  9,  9,  9,  9,  9, 
     9,  9,  9,  9,  9,  9,  9,  0,  0,  1,  0,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1
  };

  /** the input device */
  private java.io.Reader yy_reader;

  /** the current state of the DFA */
  private int yy_state;

  /** the current lexical state */
  private int yy_lexical_state = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char yy_buffer[] = new char[16384];

  /** the textposition at the last accepting state */
  private int yy_markedPos;

  /** the textposition at the last state to be included in yytext */
  private int yy_pushbackPos;

  /** the current text position in the buffer */
  private int yy_currentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int yy_startRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int yy_endRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn; 

  /** 
   * yy_atBOL == true &lt;=&gt; the scanner is currently at the beginning of a line
   */
  private boolean yy_atBOL;

  /** yy_atEOF == true &lt;=&gt; the scanner has returned a value for EOF */
  private boolean yy_atEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean yy_eof_done;

  /* user code: */
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  /* assumes correct representation of a long value for
     specified radix in String s */
  private long parseLong(String s, int radix) {
    int  max = s.length();
    long result = 0;
    long digit;

    for (int i = 0; i < max; i++) {
      digit  = Character.digit(yy_buffer[i],radix);
      result*= radix;
      result+= digit;
    }

    return result;
  }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  JrpcgenScanner(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  JrpcgenScanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed DFA transition table.
   *
   * @param packed   the packed transition table
   * @return         the unpacked transition table
   */
  private static int [] yy_unpack(String packed) {
    int [] trans = new int[7198];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1550) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do trans[j++] = value; while (--count > 0);
    }
    return trans;
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] yy_unpack_cmap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 158) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Gets the next input character.
   *
   * @return      the next character of the input stream, EOF if the
   *              end of the stream is reached.
   * @throws java.io.IOException if any kind of I/O-Error occurs
   */
  private int yy_advance() throws java.io.IOException {

    /* standard case */
    if (yy_currentPos < yy_endRead) return yy_buffer[yy_currentPos++];

    /* if the eof is reached, we don't need to work hard */ 
    if (yy_atEOF) return YYEOF;

    /* otherwise: need to refill the buffer */

    /* first: make room (if you can) */
    if (yy_startRead > 0) {
      System.arraycopy(yy_buffer, yy_startRead, 
                       yy_buffer, 0, 
                       yy_endRead-yy_startRead);

      /* translate stored positions */
      yy_endRead-= yy_startRead;
      yy_currentPos-= yy_startRead;
      yy_markedPos-= yy_startRead;
      yy_pushbackPos-= yy_startRead;
      yy_startRead = 0;
    }

    /* is the buffer big enough? */
    if (yy_currentPos >= yy_buffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[yy_currentPos*2];
      System.arraycopy(yy_buffer, 0, newBuffer, 0, yy_buffer.length);
      yy_buffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = yy_reader.read(yy_buffer, yy_endRead, 
                                            yy_buffer.length-yy_endRead);

    if ( numRead == -1 ) return YYEOF;

    yy_endRead+= numRead;

    return yy_buffer[yy_currentPos++];
  }


  /**
   * Closes the input stream.
   * 
   * @throws java.io.IOException if any kind of IO error occurs.
   */
  final public void yyclose() throws java.io.IOException {
    yy_atEOF = true;            /* indicate end of file */
    yy_endRead = yy_startRead;  /* invalidate buffer    */
    yy_reader.close();
  }


  /**
   * @return The current lexical state.
   */
  final public int yystate() {
    return yy_lexical_state;
  }

  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  final public void yybegin(int newState) {
    yy_lexical_state = newState;
  }


  /**
   * @return The text matched by the current regular expression.
   */
  final public String yytext() {
    return new String( yy_buffer, yy_startRead, yy_markedPos-yy_startRead );
  }

  /**
   * @return The length of the matched text region.
   */
  final public int yylength() {
    return yy_markedPos-yy_startRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void yy_ScanError(int errorCode) {
    try {
      System.out.println(YY_ERROR_MSG[errorCode]);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(YY_ERROR_MSG[YY_UNKNOWN_ERROR]);
    }

    System.exit(1);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number) {
    if ( number > yylength() )
      yy_ScanError(YY_PUSHBACK_2BIG);

    yy_markedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   * 
   * @throws java.io.IOException if any kind of IO error occurs.
   */
  private void yy_do_eof() throws java.io.IOException {
    if (!yy_eof_done) {
      yy_eof_done = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @throws   java.io.IOException  if any kind of I/O-Error occurs
   */
  public org.acplt.oncrpc.apps.jrpcgen.cup_runtime.Symbol next_token() throws java.io.IOException {
    int yy_input;
    int yy_action;


    while (true) {

      boolean yy_counted = false;
      for (yy_currentPos = yy_startRead; yy_currentPos < yy_markedPos;
                                                      yy_currentPos++) {
        switch (yy_buffer[yy_currentPos]) {
        case '\r':
          yyline++;
          yycolumn = 0;
          yy_counted = true;
          break;
        case '\n':
          if (yy_counted)
            yy_counted = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          yy_counted = false;
          yycolumn++;
        }
      }

      if (yy_counted) {
        if ( yy_advance() == '\n' ) yyline--;
        if ( !yy_atEOF ) yy_currentPos--;
      }

      yy_action = -1;

      yy_currentPos = yy_startRead = yy_markedPos;

      yy_state = yy_lexical_state;


      yy_forAction: {
        while (true) {

          yy_input = yy_advance();

          if ( yy_input == YYEOF ) break yy_forAction;

          int yy_next = yytrans[ yy_rowMap[yy_state] + yycmap[yy_input] ];
          if (yy_next == -1) break yy_forAction;
          yy_state = yy_next;

          int yy_attributes = YY_ATTRIBUTE[yy_state];
          if ( (yy_attributes & 1) > 0 ) {
            yy_action = yy_state; 
            yy_markedPos = yy_currentPos; 
            if ( (yy_attributes & 8) > 0 ) break yy_forAction;
          }

        }
      }


      switch (yy_action) {    

        case 160: 
          {  return symbol(JrpcgenSymbols.QUADRUPLE);  }
        case 162: break;
        case 158: 
          {  return symbol(JrpcgenSymbols.UNSIGNED);  }
        case 163: break;
        case 155: 
          {  return symbol(JrpcgenSymbols.DEFAULT);  }
        case 164: break;
        case 154: 
          {  return symbol(JrpcgenSymbols.TYPEDEF);  }
        case 165: break;
        case 153: 
          {  return symbol(JrpcgenSymbols.VERSION);  }
        case 166: break;
        case 38: 
          {  return symbol(JrpcgenSymbols.RANGLE);  }
        case 167: break;
        case 37: 
          {  return symbol(JrpcgenSymbols.LANGLE);  }
        case 168: break;
        case 36: 
          {  return symbol(JrpcgenSymbols.RBRACKET);  }
        case 169: break;
        case 35: 
          {  return symbol(JrpcgenSymbols.LBRACKET);  }
        case 170: break;
        case 34: 
          {  return symbol(JrpcgenSymbols.RBRACE);  }
        case 171: break;
        case 33: 
          {  return symbol(JrpcgenSymbols.LBRACE);  }
        case 172: break;
        case 32: 
          {  return symbol(JrpcgenSymbols.RPAREN);  }
        case 173: break;
        case 31: 
          {  return symbol(JrpcgenSymbols.LPAREN);  }
        case 174: break;
        case 30: 
          {  return symbol(JrpcgenSymbols.EQUAL);  }
        case 175: break;
        case 1: 
        case 4: 
        case 9: 
          {  throw new Error("Illegal character \"" + yytext() + "\"");  }
        case 176: break;
        case 2: 
        case 3: 
        case 67: 
          {  /* ignore */  }
        case 177: break;
        case 5: 
          {  return symbol(JrpcgenSymbols.STAR);  }
        case 178: break;
        case 27: 
          {  return symbol(JrpcgenSymbols.SEMICOLON);  }
        case 179: break;
        case 28: 
          {  return symbol(JrpcgenSymbols.COMMA);  }
        case 180: break;
        case 29: 
          {  return symbol(JrpcgenSymbols.COLON);  }
        case 181: break;
        case 78: 
          {  return symbol(JrpcgenSymbols.INT);  }
        case 182: break;
        case 97: 
          {  return symbol(JrpcgenSymbols.VOID);  }
        case 183: break;
        case 99: 
          {  return symbol(JrpcgenSymbols.ENUM);  }
        case 184: break;
        case 107: 
          {  return symbol(JrpcgenSymbols.CASE);  }
        case 185: break;
        case 108: 
          {  return symbol(JrpcgenSymbols.CHAR);  }
        case 186: break;
        case 116: 
          {  return symbol(JrpcgenSymbols.LONG);  }
        case 187: break;
        case 117: 
        case 150: 
          {  return symbol(JrpcgenSymbols.BOOL);  }
        case 188: break;
        case 125: 
          {  return symbol(JrpcgenSymbols.SHORT);  }
        case 189: break;
        case 128: 
          {  return symbol(JrpcgenSymbols.CONST);  }
        case 190: break;
        case 132: 
          {  return symbol(JrpcgenSymbols.FLOAT);  }
        case 191: break;
        case 133: 
          {  return symbol(JrpcgenSymbols.HYPER);  }
        case 192: break;
        case 135: 
          {  return symbol(JrpcgenSymbols.UNION);  }
        case 193: break;
        case 139: 
          {  return symbol(JrpcgenSymbols.OPAQUE);  }
        case 194: break;
        case 141: 
          {  return symbol(JrpcgenSymbols.STRING);  }
        case 195: break;
        case 142: 
          {  return symbol(JrpcgenSymbols.STRUCT);  }
        case 196: break;
        case 143: 
          {  return symbol(JrpcgenSymbols.SWITCH);  }
        case 197: break;
        case 147: 
          {  return symbol(JrpcgenSymbols.DOUBLE);  }
        case 198: break;
        case 152: 
          {  return symbol(JrpcgenSymbols.PROGRAM);  }
        case 199: break;
        case 6: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        case 24: 
        case 25: 
        case 26: 
        case 43: 
        case 44: 
        case 45: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
        case 60: 
        case 61: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 98: 
        case 100: 
        case 101: 
        case 102: 
        case 103: 
        case 104: 
        case 105: 
        case 106: 
        case 109: 
        case 110: 
        case 111: 
        case 112: 
        case 113: 
        case 114: 
        case 115: 
        case 118: 
        case 119: 
        case 120: 
        case 121: 
        case 122: 
        case 123: 
        case 124: 
        case 126: 
        case 127: 
        case 129: 
        case 130: 
        case 131: 
        case 134: 
        case 136: 
        case 137: 
        case 138: 
        case 140: 
        case 144: 
        case 145: 
        case 146: 
        case 148: 
        case 149: 
        case 151: 
        case 156: 
        case 157: 
        case 159: 
          { 
        return symbol(JrpcgenSymbols.IDENTIFIER, yytext());
     }
        case 200: break;
        case 7: 
        case 8: 
        case 41: 
        case 69: 
          { 
        return symbol(JrpcgenSymbols.INTEGER_LITERAL, yytext());
     }
        case 201: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
            yy_do_eof();
              {     return new Symbol(JrpcgenSymbols.EOF);
 }
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }    


}
