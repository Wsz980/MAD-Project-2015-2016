using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAppTest1
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            JApplePlaceHolder.Controls.Add(new LiteralControl("<iframe src=\"JavaApplet.html\" height=\"1000\" width=\"1000\"></iframe>"));
            //NOTE: you should probably make the applets have their own .aspx pages rather than an HTML as it may be harder to define in an iframe (http://stackoverflow.com/questions/5015070/using-iframes-in-asp-net)
            
        }
    }
}