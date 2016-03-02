using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Threading;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAppTest1
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        private List<string> vocabWords = null;
        private List<string> vocabDefinitions = null;

        private List<TextBox> listOfBoxes = null;
        private List<string> listOfIds = null;

        private const string BOXESLIST_SESSION = "ListOfBoxes";
        private const string IDSLIST_SESSION = "ListOfIds";
        protected void Page_Load(object sender, EventArgs e)
        {
            testAgainButton.Enabled = false;

            if (!Page.IsPostBack)
            {
                Session[BOXESLIST_SESSION] = null;
                Session[IDSLIST_SESSION] = null;
            }
            else
            {
                listOfBoxes = (List<TextBox>)Session[BOXESLIST_SESSION];
                listOfIds = (List<string>)Session[IDSLIST_SESSION];
            }
            if ((Session["VocabWords"] != null) && (Session["VocabDefinitions"] != null))
            {
                vocabWords = (List<string>)Session["VocabWords"];
                vocabDefinitions = (List<string>)Session["VocabDefinitions"];
            }
            else
            {
                //Response.Write("<script>alert('Error: Please enter vocabulary words and definitions on the Vocabulary List page before taking a test.');</script>");
                //Thread.Sleep(5000);
                Response.Redirect("~/SuperDuper.aspx");

            }

        }

        private const string PARTSHOWN_SESSION = "PartShown";
        protected void Page_PreRender()
        {
            if (!Page.IsPostBack)
            {
                Session[PARTSHOWN_SESSION] = null;
                WordsShowing();
            }

            if (wordShowingClicked)
            {
                WordsShowing();
            }
            if (definitionsShowingClicked)
            {
                DefinitionsShowing();
            }
            if (submitTestClicked)
            {
                SubmitTest();
            }

        }

        private bool wordShowingClicked = false;

        protected void showWords_Click(object sender, EventArgs e)
        {
            wordShowingClicked = true;
        }

        private string wordsShown = "Words";
        private void WordsShowing()
        {
            testPanel.Controls.Clear();
            List<TextBox> listOfBoxes = new List<TextBox>();
            List<string> listOfIDs = new List<string>();
            Session[BOXESLIST_SESSION] = listOfBoxes;
            Session[IDSLIST_SESSION] = listOfIDs;

            for (int a = 0; a < vocabWords.Count; a++)
            {
                //TextBox wordBox = new TextBox();
                Label shownWord = new Label();
                TextBox defBox = new TextBox();

                Label semicolonLabel = new Label();

                semicolonLabel.Text = ": ";

                testPanel.Controls.Add(shownWord);
                testPanel.Controls.Add(semicolonLabel);
                testPanel.Controls.Add(new LiteralControl("&nbsp;"));
                testPanel.Controls.Add(defBox);
                testPanel.Controls.Add(new LiteralControl("<br/><br/>"));

                shownWord.Text = vocabWords[a];
                shownWord.Font.Name = "Times New Roman";
                defBox.ID = "_HIDDENdef" + a.ToString();

                Session[PARTSHOWN_SESSION] = wordsShown;
                listOfBoxes.Add(defBox);
                listOfIDs.Add(defBox.UniqueID);
            }

        }

        private bool definitionsShowingClicked = false;

        protected void showDefinitions_Click(object sender, EventArgs e)
        {
            definitionsShowingClicked = true;
        }

        private string definitionsShown = "Definitions";
        private void DefinitionsShowing()
        {
            List<TextBox> listOfBoxes = new List<TextBox>();
            List<string> listOfIDs = new List<string>();
            Session[BOXESLIST_SESSION] = listOfBoxes;
            Session[IDSLIST_SESSION] = listOfIDs;

            for (int a = 0; a < vocabDefinitions.Count; a++)
            {
                TextBox wordBox = new TextBox();
                Label shownDefLabel = new Label();

                Label semicolonLabel = new Label();

                semicolonLabel.Text = ": ";

                testPanel.Controls.Add(shownDefLabel);
                testPanel.Controls.Add(semicolonLabel);
                testPanel.Controls.Add(new LiteralControl("&nbsp;"));
                testPanel.Controls.Add(wordBox);
                testPanel.Controls.Add(new LiteralControl("<br/><br/>"));
                //testPanel.Controls.Add(wordBox);
                //testPanel.Controls.Add(new LiteralControl("&nbsp;"));
                //testPanel.Controls.Add(defLabel);
                //testPanel.Controls.Add(defBox);
                //testPanel.Controls.Add(new LiteralControl("<br/><br/>"));

                shownDefLabel.Text = vocabDefinitions[a];
                shownDefLabel.Font.Name = "Times New Roman";
                wordBox.ID = "_HIDDENword" + a.ToString();

                Session[PARTSHOWN_SESSION] = definitionsShown;
                listOfBoxes.Add(wordBox);
                listOfIDs.Add(wordBox.UniqueID);
            }

        }

        private bool submitTestClicked = false;
        protected void submitTestButton_Click(object sender, EventArgs e)
        {
            submitTestClicked = true;
        }

        private List<string> testAnswers = new List<string>();

        private void SubmitTest()
        {
            //foreach (Control ctrl in testPanel.Controls)
            //{
            //    if (ctrl is TextBox)
            //    {
            //        testAnswers.Add((ctrl as TextBox).Text);
            //    }

            //}
            foreach (TextBox box in listOfBoxes)
            {
                if (listOfIds.Contains(box.UniqueID))
                {
                    if (Request.Form[box.UniqueID] != null)
                    {
                        testAnswers.Add(Request.Form[box.UniqueID].ToString());
                    }
                }
            }

            AnalyzeAnswers();
        }

        List<string> incorrectAnswers = new List<string>();
        int correctAnswers = 0;
        private void AnalyzeAnswers()
        {
            testPanel.Controls.Clear();
            if (Session[PARTSHOWN_SESSION].Equals(wordsShown))
            {
                for (int a = 0; a < vocabWords.Count; a++)
                {
                    if (testAnswers[a].ToUpper() == vocabDefinitions[a].ToUpper())
                    //if (testAnswers[a] == vocabDefinitions[a])
                    {
                        correctAnswers++;
                    }
                    else
                    {
                        incorrectAnswers.Add(testAnswers[a]);
                    }
                }
            }
            else
            {
                for (int a = 0; a < vocabDefinitions.Count; a++)
                {
                    if (testAnswers[a].ToUpper() == vocabWords[a].ToUpper())
                    {
                        correctAnswers++;
                    }
                    else
                    {
                        incorrectAnswers.Add(testAnswers[a]);
                    }
                }
            }
            postSubmitTest();
        }


        private void postSubmitTest()
        {
            showWords.Enabled = false;
            showDefinitions.Enabled = false;
            submitTestButton.Enabled = false;
            testAgainButton.Enabled = true;

            Label correct = new Label();
            Label incorrect = new Label();

            if (Session[PARTSHOWN_SESSION].Equals(wordsShown))
            {
                correct.Text = "Test Score: " + correctAnswers.ToString() + "/" + vocabDefinitions.Count.ToString();
            }
            else
            {
                correct.Text = "Test Score: " + correctAnswers + "/" + vocabWords.Count;
            }

            string incorrectAnswersListtoString = string.Join(", ", incorrectAnswers.ToArray());

            incorrect.Text = "Incorrect Answers: " + incorrectAnswersListtoString;


            testPanel.Controls.Clear();
            testPanel.Controls.Add(correct);
            testPanel.Controls.Add(new LiteralControl("<br/><br/>"));
            testPanel.Controls.Add(incorrect);
            testPanel.Controls.Add(new LiteralControl("<br/><br/>"));

            if (Session[PARTSHOWN_SESSION].Equals(wordsShown))
            {
                for (int a = 0; a < vocabWords.Count; a++)
                {

                    Label WordLabel = new Label();
                    Label DefLabel = new Label();

                    Label semicolonLabel = new Label();

                    //semicolonLabel.Text = ": ";

                    testPanel.Controls.Add(WordLabel);
                    testPanel.Controls.Add(new LiteralControl(": "));
                    testPanel.Controls.Add(new LiteralControl("&nbsp;"));
                    testPanel.Controls.Add(DefLabel);
                    testPanel.Controls.Add(new LiteralControl("<br/><br/>"));

                    WordLabel.Text = vocabWords[a];
                    DefLabel.Text = vocabDefinitions[a];
                }

            }
            else
            {
                for (int a = 0; a < vocabDefinitions.Count; a++)
                {

                    Label WordLabel = new Label();
                    Label DefLabel = new Label();

                    Label semicolonLabel = new Label();

                    semicolonLabel.Text = ": ";

                    testPanel.Controls.Add(WordLabel);
                    testPanel.Controls.Add(semicolonLabel);
                    testPanel.Controls.Add(new LiteralControl("&nbsp;"));
                    testPanel.Controls.Add(DefLabel);
                    testPanel.Controls.Add(new LiteralControl("<br/><br/>"));

                    WordLabel.Text = vocabWords[a];
                    DefLabel.Text = vocabDefinitions[a];
                }

            }

        }

        protected void testAgainButton_Click(object sender, EventArgs e)
        {
            showWords.Enabled = true;
            showDefinitions.Enabled = true;
            submitTestButton.Enabled = true;
            testAgainButton.Enabled = false;

            wordShowingClicked = true;
        }
    }
}

/*
 *FOLLOWING WORKS:
 *
 * 
 *use when checking whether or not they got it correct (only checks one of the groups of boxes)
 *can alternatively check all of them and then subtract half of the total (ex.: 20 total, so there will be 10 answers. checks all of them and then gives a score
 *(ex.: 19/20), from which then is subtracted 10 for the part that was displayed (words/def.) (19-10/10 or 9/10). This method will likely be better, but the below may
 *prove useful for something else.
 *
 *read below but keep in mind CODE BELOW STILL NEEDED IN ORDER TO DIFFERENTIATE BETWEEN THE TWO TYPES OF BOXES WHEN CHECKING IN ORDER TO CREATE THE _HIDDENdefinitions LIST
 *
 * again alternatively can simply create a list that has the answers and a boolean that tells whether they hid words or definitions. Bool decides between two paths,
 * then the two correspodning lists (ex. _HIDDENdefinitions and vocabDefinitions) are compared. probably the best method
 * 
        protected void Page_Load(object sender, EventArgs e)
        {
            WordsShowing();
        }

    private void WordsShowing()
        {
            int a = 0;
            TextBox temp = new TextBox();
            testPanel.Controls.Add(temp);
            temp.ID = "Spooky" + a.ToString();
        } 
 
        protected void Page_PreRender()
        {
            foreach(Control ctrl in testPanel.Controls){
                if (ctrl is TextBox) {

                    if ((ctrl as TextBox).ID.Contains("Spooky")) {

                        Response.Write("<script>alert('HALLELUJA.');</script>");
                    }
                }
            }
        }
 * 
*/