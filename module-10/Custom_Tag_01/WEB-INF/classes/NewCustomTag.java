package myTags;
/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 */
public class NewCustomTag extends javax.servlet.jsp.tagext.BodyTagSupport {

    public NewCustomTag() {
        super();
    }

    private void writeTagBodyContent(javax.servlet.jsp.JspWriter out, javax.servlet.jsp.tagext.BodyContent bodyContent) throws java.io.IOException {
        bodyContent.writeOut(out);
        bodyContent.clearBody();
    }

    @Override
    public int doStartTag() throws javax.servlet.jsp.JspException {
        
        if (theBodyShouldBeEvaluated()) {
            return EVAL_BODY_BUFFERED;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws javax.servlet.jsp.JspException {
        
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        
        try{
            out.println("Custom Tag #Two<br />");
        }
        catch(Exception e){
            
        }
        
        if (shouldEvaluateRestOfPageAfterEndTag()) {
            return EVAL_PAGE;
        } else {
            return SKIP_PAGE;
        }
    }

    @Override
    public int doAfterBody() throws javax.servlet.jsp.JspException {
        try {
            javax.servlet.jsp.tagext.BodyContent bodyCont = getBodyContent();
            javax.servlet.jsp.JspWriter out = bodyCont.getEnclosingWriter();
            
            writeTagBodyContent(out, bodyCont);
        } catch (Exception ex) {
            handleBodyContentException(ex);
        }
        
        if (theBodyShouldBeEvaluatedAgain()) {
            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }

    private void handleBodyContentException(Exception ex) throws javax.servlet.jsp.JspException {
        throw new javax.servlet.jsp.JspException("Error in NewCustomTag tag", ex);
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
