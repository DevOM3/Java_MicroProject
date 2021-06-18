package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class playground_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/css/playground.css");
    _jspx_dependants.add("/js/playground.js");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>SPS | Playground</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            ");
      out.write("html, \n");
      out.write("body {\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    background: white;\n");
      out.write("    height: 100vh;\n");
      out.write("}\n");
      out.write(".playground-section {\n");
      out.write("}\n");
      out.write("\n");
      out.write(".top {\n");
      out.write("    height: 25vh;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".center {\n");
      out.write("    height: 50vh;\n");
      out.write("    display: grid;\n");
      out.write("    place-items: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table {\n");
      out.write("    background: white;\n");
      out.write("    font-family: arial, sans-serif;\n");
      out.write("    border-collapse: collapse;\n");
      out.write("    width: 98%;\n");
      out.write("    max-width: 800px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("td, th {\n");
      out.write("    border: 1px solid grey;\n");
      out.write("    text-align: center;\n");
      out.write("    padding: 8px;\n");
      out.write("}\n");
      out.write("td:nth-child(2), th:nth-child(2) {\n");
      out.write("    width: 70%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("tr:nth-child(even) {\n");
      out.write("    background-color: #dddddd;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".bottom {\n");
      out.write("    padding: 7px;\n");
      out.write("    height: calc(25vh - 15px);\n");
      out.write("    display: flex;\n");
      out.write("    align-items: center;\n");
      out.write("    justify-content: space-around;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".button {\n");
      out.write("    height: 100%;\n");
      out.write("    width: 25vw;\n");
      out.write("    pading: 0px;\n");
      out.write("    padding: 4px;\n");
      out.write("    display: flex;\n");
      out.write("    flex-direction: column;\n");
      out.write("    align-items: center;\n");
      out.write("    justify-content: flex-end;\n");
      out.write("    border: 1px solid lightgrey;\n");
      out.write("    background: white;\n");
      out.write("    border-radius: 7px;\n");
      out.write("    cursor: pointer;\n");
      out.write("    transition: 521ms ease;\n");
      out.write("}\n");
      out.write(".button:hover {\n");
      out.write("    background: black;\n");
      out.write("}\n");
      out.write(".button:hover p {\n");
      out.write("    color: white;\n");
      out.write("}\n");
      out.write("\n");
      out.write("img {\n");
      out.write("    width: 100%;\n");
      out.write("    height: 85%;\n");
      out.write("    margin: 0px;\n");
      out.write("    object-fit: contain;\n");
      out.write("    border: none;\n");
      out.write("    outline: none;\n");
      out.write("    border-radius: 11px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".button p {\n");
      out.write("    margin: 0;\n");
      out.write("    margin-top: 2px;\n");
      out.write("    font-size: 16px;\n");
      out.write("    transition: 521ms ease;\n");
      out.write("}\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            ");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section class=\"playground-section\">\n");
      out.write("            <div class=\"top\"/>\n");
      out.write("            <img id=\"ai-response\" src=\"https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/icon.png?alt=media&token=2ee66a1c-336b-46da-a561-58682c48b8fb\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"center\">\n");
      out.write("                <table>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Match Number</td>\n");
      out.write("                            <td>Winner</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>1</td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>2</td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>3</td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"bottom\">\n");
      out.write("                <button class=\"button\" data-option=\"Stone\"  onclick=\"handleButtonClick()\">\n");
      out.write("                    <img \n");
      out.write("                        src=\"https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/stone.png?alt=media&token=af3a0a57-8712-459d-9f74-8812d3190f5e\"\n");
      out.write("                        alt=\"\"\n");
      out.write("                        onmouseover=\"this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/stone-hand.png?alt=media&token=d61af72d-5fc3-4ef4-81a9-94d04b98c578';\"\n");
      out.write("                        onmouseout=\"this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/stone.png?alt=media&token=af3a0a57-8712-459d-9f74-8812d3190f5e';\"\n");
      out.write("                    />\n");
      out.write("                    <p>Stone</p>\n");
      out.write("                </button>\n");
      out.write("                <button class=\"button\" data-option=\"Paper\"  onclick=\"handleButtonClick()\">\n");
      out.write("                    <img \n");
      out.write("                        src=\"https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/paper.png?alt=media&token=85504b82-656a-46b8-8537-dc2acf343407\"\n");
      out.write("                        alt=\"\"\n");
      out.write("                        onmouseover=\"this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/paper-hand.png?alt=media&token=ffd7c467-11e8-436a-bed2-2b715bad8171';\"\n");
      out.write("                        onmouseout=\"this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/paper.png?alt=media&token=85504b82-656a-46b8-8537-dc2acf343407';\"\n");
      out.write("                    />\n");
      out.write("                    <p>Paper</p>\n");
      out.write("                </button>\n");
      out.write("                <button class=\"button\" data-option=\"Scrssor\" onclick=\"handleButtonClick()\">\n");
      out.write("                    <img \n");
      out.write("                        src=\"https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/scissor.png?alt=media&token=81b7c7e1-0fd4-4fb5-9753-6ab1e68fef7c\"\n");
      out.write("                        alt=\"\"\n");
      out.write("                        onmouseover=\"this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/scissor-hand.png?alt=media&token=60535711-4e28-4fbd-8293-815087a81840';\"\n");
      out.write("                        onmouseout=\"this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/scissor.png?alt=media&token=81b7c7e1-0fd4-4fb5-9753-6ab1e68fef7c';\"\n");
      out.write("                    />\n");
      out.write("                    <p>Scissor</p>\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        const imageArray = [\n");
      out.write("            \"https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/stone.png?alt=media&token=af3a0a57-8712-459d-9f74-8812d3190f5e\",\n");
      out.write("            \"https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/paper.png?alt=media&token=85504b82-656a-46b8-8537-dc2acf343407\",\n");
      out.write("            \"https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/scissor.png?alt=media&token=81b7c7e1-0fd4-4fb5-9753-6ab1e68fef7c\"\n");
      out.write("        ];\n");
      out.write("        const handleButtonClick = () => {\n");
      out.write("            document.getElementById(\"ai-response\").src = imageArray[Math.floor(Math.random() * imageArray.length)];\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
