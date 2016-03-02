/*
 * KNOW ISSUES:
 * 
 * 1. Save Button refuses to save anything unless it was inputted after hitting "Submit" (so if reloading/import a file/etc., save file will either provide a
 * blank document (reloading) or will not download anything (importing a file).
*/
using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;
namespace WebAppTest1
{
    public partial class SuperDuper : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            saveButton.Enabled = false;
            if (!Page.IsPostBack)
            {
                //listOfIds = new List<string>();
                //listOfBoxes = new List<TextBox>();
                Session["ListOfIds"] = listOfIds;
                Session["listOfBoxes"] = listOfBoxes;
                Session["VocabWords"] = null;
                Session["VocabDefintions"] = null;
            }
            else
            {
                listOfIds = (List<string>)Session["ListOfIds"];
                listOfBoxes = (List<TextBox>)Session["listOfBoxes"];

            }
        }

        bool skipPreRender = false;


        protected void Page_PreRender() 
        {

            if (skipPreRender)
                return;


            if (Page.IsPostBack)
            {
                if (importClicked)
                {
                    ImportButtonClicked();
                }
                else
                {
                    if ((Session["ListOfIds"] != null) && (Session["listOfBoxes"] != null))
                    {
                        saveButton.Enabled = true;
                        int wordOrDefBox = 1;

                        foreach (TextBox box in listOfBoxes)
                        {

                            Label wordLabel = new Label();
                            Label defLabel = new Label();

                            TextBox wordBox = new TextBox();
                            TextBox defBox = new TextBox();

                            wordLabel.Text = "Word: ";
                            defLabel.Text = "Definition: ";

                            //panel1.Controls.Add(wordLabel);
                            //panel1.Controls.Add(new LiteralControl("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));
                            //panel1.Controls.Add(wordBox);
                            //panel1.Controls.Add(new LiteralControl("<br/>"));
                            //panel1.Controls.Add(defLabel);
                            //panel1.Controls.Add(defBox);
                            //panel1.Controls.Add(new LiteralControl("<br/><br/>"));

                            if (listOfIds.Contains(box.UniqueID))
                            {
                                if (Request.Form[box.UniqueID] != null)
                                {
                                    if (IsOdd(wordOrDefBox))
                                    {
                                        panel1.Controls.Add(wordLabel);
                                        //panel1.Controls.Add(new LiteralControl("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));
                                        panel1.Controls.Add(wordBox);
                                        //panel1.Controls.Add(new LiteralControl("<br/>"));
                                        panel1.Controls.Add(new LiteralControl("&nbsp;"));
                                        wordBox.Text = Request.Form[box.UniqueID].ToString();
                                        wordOrDefBox++;
                                    }
                                    else
                                    {
                                        panel1.Controls.Add(defLabel);
                                        panel1.Controls.Add(defBox);
                                        panel1.Controls.Add(new LiteralControl("<br/><br/>"));
                                        defBox.Text = Request.Form[box.UniqueID].ToString();
                                        wordOrDefBox++;
                                    }
                                    //box.Text = Request.Form[box.UniqueID].ToString();
                                    // ???: Shouldn't this print the box ID? Why does it print the actual text in the box?
                                }
                            }


                        }

                        if (saveCLicked)
                        {
                            SaveButtonClick();
                        }
                        if (testClicked)
                        {
                            TestButtonClick();
                        }
                    }
                }
            }
        }


        private List<string> listOfIds = null;
        private List<TextBox> listOfBoxes = null;

        protected void submitButton_Click(object sender, EventArgs e)
        {

            string toIntString = TextBox1.Text;
            if (toIntString.Trim().Length == 0)
            {
                Response.Write("<script>alert('Error: Please input an integer into the textbox above.');</script>");
                return;
            }
            int vocabBoxQuantity;

            listOfIds = new List<string>();
            listOfBoxes = new List<TextBox>();
            Session["ListOfIds"] = listOfIds;
            Session["listOfBoxes"] = listOfBoxes;
            //This disposes of the old lists and sessions, as otherwise if you were to enter a new # of boxes it would end up adding on to the previous sessions,
            //generating an incorrect amount of boxes and breaking the programs other functions.

            if (Int32.TryParse(toIntString, out vocabBoxQuantity) == true)
            {
                saveButton.Enabled = true;
                //generateVocabularyBoxes();
                for (int a = 0; a < vocabBoxQuantity; a++)
                {
                    //for the creation of multiple unique textbox ID's
                    //string wordBoxID = "vocabBox" + a;
                    //string defBoxID = "vocabBox" + a;
                    //NOTE: change from "textbox" to something like "vocabbox" to prevent the potential creation of multiple ID's of the same value?


                    //Button but1 = new Button();
                    //Button but2 = new Button();

                    //but1.Text = "But " + a.ToString();
                    //but2.Text = "Crap " + a.ToString();

                    //but1.ID = "But1" + a.ToString();
                    //but2.ID = "But2" + a.ToString();

                    //but2.Click += new EventHandler(this.but2_Click);
                    //but1.Click += new EventHandler(this.but2_Click); ;

                    //but1.Command += but1_Command;



                    //panel1.Controls.Add(but1);
                    //panel1.Controls.Add(but2);


                    TextBox wordBox1 = new TextBox();
                    TextBox defBox1 = new TextBox();

                    wordBox1.ID = "vocabWordBox" + a.ToString();
                    defBox1.ID = "vocabDefBox" + a.ToString();

                    Label wordLabel = new Label();
                    Label defLabel = new Label();

                    wordLabel.Text = "Word: ";
                    defLabel.Text = "Definition: ";

                    panel1.Controls.Add(wordLabel);
                    //panel1.Controls.Add(new LiteralControl("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));
                    panel1.Controls.Add(wordBox1);
                    panel1.Controls.Add(new LiteralControl("&nbsp;"));
                    panel1.Controls.Add(defLabel);
                    panel1.Controls.Add(defBox1);
                    panel1.Controls.Add(new LiteralControl("<br/><br/>"));

                    // panel1.ViewStateMode = System.Web.UI.ViewStateMode.Enabled;
                    //panel1.EnableViewState = true;

                    //wordBox1.ClientIDMode = System.Web.UI.ClientIDMode.Static;

                    listOfIds.Add(wordBox1.UniqueID);
                    listOfIds.Add(defBox1.UniqueID);
                    listOfBoxes.Add(wordBox1);
                    listOfBoxes.Add(defBox1);
                    // ???: Does it matter if you call the list (listOfIds) or the session (ListOfIds)?

                    //<p>
                    //  Word: 
                    //    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
                    //   <br />Definition: 
                    //    <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
                    //</p>
                    // ^^^ HTML to be duplicated


                    skipPreRender = true;
                }
            }
            //else
            //{
            //    Response.Write("<script>alert('Error: Please input an integer into the textbox above.');</script>");
            //    /*
            //    code below causes everything under the panel to disappear when the message is displayed (as it is rendered beforehand and stops to wait
            //    for user input). Hence, Response.Write will be used instead
            //    */
            //    //panel1.Controls.Add(new LiteralControl("<script>alert('Error: Please input and integer into the textbox above.');</script>"));
            //}
        }

        private bool saveCLicked = false;

        protected void saveButton_Click(object sender, EventArgs e)
        {
            saveCLicked = true;

        }

        private void SaveButtonClick()
        {
            saveButton.Enabled = true;
            //string results = string.Empty;

            List<string> results = new List<string>();

            //int listLocation = 0;
            foreach (Control cl in panel1.Controls)
            {
                //listLocation++;
                if (cl is TextBox)
                {
                    results.Add((cl as TextBox).Text);
                }
            }
            // ???: Why don't the definition boxes count as textboxes as the above simply skips them?
            String FileName = "VocabularyList.txt";
            Response.ClearContent();
            Response.Buffer = true;
            Response.AddHeader("content-disposition", string.Format("attachment; filename={0}", FileName));
            Response.ContentType = "text";
            StringWriter vocabWriter = new StringWriter();


            for (int listSize = 0; listSize < results.Count; listSize++)
            {
                vocabWriter.WriteLine(results[listSize]);
            }
            Response.Write(vocabWriter.ToString());
            Response.End();

            //foreach (Control cl in panel1.Controls)
            //{
            //    if (cl is TextBox)
            //    {
            //        results += (cl as TextBox).Text;
            //        //TextBox bla = (TextBox)cl;
            //        //results = ((TextBox)cl).Text;
            //        //TextBox asdf = (TextBox)cl;

            //    }
            //}

            NameValueCollection pColl = Request.Params;
            // ???: What is this?

            //foreach (var ids in listOfIds)
            ////why doesn't this crash when nothin is entered into the boxes? cuz it is null I guess. Why did I ask this?
            //{
            //    if ((this.Page.Form.HasControls()) && (pColl != null))
            //    {
            //        string value = Request.Form[ids].ToString();
            //        //What is all of this?
            //        //Control cl = this.Form.FindControl(ids);
            //        //if(null != cl)
            //        //{
            //        //    results += (cl as TextBox).Text;
            //        //}
            //    }
            //}
        }
        private bool importClicked = false;
        protected void importButton_Click(object sender, EventArgs e)
        {
            importClicked = true;
        }



        private void ImportButtonClicked()
        {
            if (vocabFileUpload.HasFile == false)
            {
                Response.Write("<script>alert('Error: Please upload a file into the file upload prompt above.');</script>");
                return;
            }
            else
            {
                saveButton.Enabled = true;
            }

            listOfIds = new List<string>();
            listOfBoxes = new List<TextBox>();
            Session["ListOfIds"] = listOfIds;
            Session["listOfBoxes"] = listOfBoxes;

            string fileName = string.Empty;

            fileName = "vocabFile_" + Guid.NewGuid().ToString();

            vocabFileUpload.SaveAs(Server.MapPath("Vocab_Lists\\" + fileName));

            //System.IO.StreamReader vocabFileStreamReader = new System.IO.StreamReader(@"C:\Users\Victor\Documents\Visual Studio 2013\Projects\WebAppTest1\Vocab_Lists\" + fileName);
            System.IO.StreamReader vocabFileStreamReader = new System.IO.StreamReader(Server.MapPath("Vocab_Lists\\" + fileName));
            int wordOrDef = 1;
            string lines = string.Empty;

            List<string> listOfWords = new List<string>();
            List<string> listOfDefinitions = new List<string>();

            while ((lines = vocabFileStreamReader.ReadLine()) != null)
            {
                if (string.IsNullOrEmpty(lines))
                    continue;

                if (IsOdd(wordOrDef))
                {
                    listOfWords.Add(lines.ToString());
                    wordOrDef++;
                }
                else
                {
                    listOfDefinitions.Add(lines);
                    wordOrDef++;
                }

            }

            vocabFileStreamReader.Close();
            //foreach (TextBox box in listOfBoxes)
            //    {

            //        if (listOfIds.Contains(box.UniqueID))
            //        {
            //            if (Request.Form[box.UniqueID] != null)
            //            {
            //                box.Text = Request.Form[box.UniqueID].ToString();
            //                // ???: Shouldn't this print the box ID? Why does it print the actual text in the box?
            //            }
            //        }
            for (int wordDefQuantity = 0; wordDefQuantity < listOfWords.Count; wordDefQuantity++)
            {

                Label wordLabel = new Label();
                Label defLabel = new Label();

                TextBox wordBox = new TextBox();
                TextBox defBox = new TextBox();

                wordBox.ID = "vocabWordBox" + wordDefQuantity.ToString();
                defBox.ID = "vocabDefBox" + wordDefQuantity.ToString();

                wordLabel.Text = "Word: ";
                defLabel.Text = "Definition: ";

                panel1.Controls.Add(wordLabel);
                //panel1.Controls.Add(new LiteralControl("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));
                panel1.Controls.Add(wordBox);
                wordBox.Text = listOfWords[wordDefQuantity];
                panel1.Controls.Add(new LiteralControl("&nbsp;"));
                panel1.Controls.Add(defLabel);
                panel1.Controls.Add(defBox);
                defBox.Text = listOfDefinitions[wordDefQuantity];
                panel1.Controls.Add(new LiteralControl("<br/><br/>"));

                listOfBoxes.Add(wordBox);
                listOfBoxes.Add(defBox);

                listOfIds.Add(wordBox.UniqueID);
                listOfIds.Add(defBox.UniqueID);

                //the above will fix the saving issue but for some reason that i couldn't give a rats ass about doesnt work. fix it later chump

            }

        }
        private static bool IsOdd(int value)
        {
            return value % 2 != 0;
        }
        private bool testClicked = false;
        protected void vocabTestButton_Click(object sender, EventArgs e)
        {
            testClicked = true;
        }

        //private List<string> vocabWords = null;
        //private List<string> vocabDefinitions = null;

        private const string DEFINITION_SESSION = "VocabDefinitions";

        private void TestButtonClick()
        {
            List<string> vocabWords = new List<string>();
            List<string> vocabDefinitions = new List<string>();
            int sortDefsOrWords = 1;
            foreach (Control ctrls in panel1.Controls)
            {
                if (ctrls is TextBox)
                {
                    if (IsOdd(sortDefsOrWords))
                    {
                        vocabWords.Add((ctrls as TextBox).Text);
                        sortDefsOrWords++;
                    }
                    else
                    {
                        vocabDefinitions.Add((ctrls as TextBox).Text);
                        sortDefsOrWords++;
                    }
                }

            }

            Session["VocabWords"] = vocabWords;
            Session[DEFINITION_SESSION] = vocabDefinitions;

            Response.Redirect("~/Test.aspx");
        }
        //public void Redirect(string url) { 


        //}

        //void but1_Command(object sender, CommandEventArgs e)
        //{
        //    throw new NotImplementedException();
        //}

        //void but2_Click(object sender, EventArgs e)
        //{
        //    throw new Exception("Blah");
        //}
        //public void generateVocabularyBoxes()
        //{


        //    //Response.Write("");
        //}
    }
}