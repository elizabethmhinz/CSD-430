package dbTags;
/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 */
public class QueryResultsNoTableMySQL extends javax.servlet.jsp.tagext.BodyTagSupport {
    String password = "pass";
    String userID = "student1";
    String team = null;

    public QueryResultsNoTableMySQL() {
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
        javax.servlet.jsp.JspWriter out = null;
        try{
            dbBeans.MyDatabaseBeanMySQL myBean = new dbBeans.MyDatabaseBeanMySQL();
            myBean.setPassword(password);
            myBean.setUserID(userID);
            out = pageContext.getOut();
            java.sql.ResultSet resultSet;
            resultSet = myBean.getResults("SELECT * FROM World_Series WHERE Team = '" + team + "' OR LoserTeam = '" + team + "'");
            try{
                while(resultSet.next()){
                    for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                        out.print((resultSet.getString(i)).trim() + ", ");
                    }
                    out.println("<br /><hr /><br />");
                }
                myBean.closeConnection();
            }
            catch(Exception e){
                out.println("<b>Print of results failed.</b><br />");
            }
        }
        catch(Exception e){
        }
        return super.doEndTag();
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
        throw new javax.servlet.jsp.JspException("Error in QueryResultsNoTableMySQL tag", ex);
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
    
    public void setSelectTeam(String team){

    this.team = team;
  }
}
