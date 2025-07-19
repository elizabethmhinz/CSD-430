package myTags;
/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 */
public class CustomTagThree extends javax.servlet.jsp.tagext.BodyTagSupport {

    public CustomTagThree() {
        super();
    }

    private void writeTagBodyContent(javax.servlet.jsp.JspWriter out, javax.servlet.jsp.tagext.BodyContent bodyContent) throws java.io.IOException {
        bodyContent.writeOut(out);
        bodyContent.clearBody();
    }

    @Override
    public int doEndTag() throws javax.servlet.jsp.JspException {
 
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        
        try{
            out.println("Custom Tag #Three<br />");
        }
        catch(Exception e){
            
        }
        
        if (shouldEvaluateRestOfPageAfterEndTag()) {
            return EVAL_PAGE;
        } else {
            return SKIP_PAGE;
        }
    }

    private boolean shouldEvaluateRestOfPageAfterEndTag() {
        return true;
    }

    private boolean theBodyShouldBeEvaluatedAgain() {
        return false;
    }

    private boolean theBodyShouldBeEvaluated() {
        return true;
    }    
}
