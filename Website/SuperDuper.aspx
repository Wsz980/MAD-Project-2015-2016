<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="SuperDuper.aspx.cs" Inherits="WebAppTest1.SuperDuper" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div>
        <p>
            Welcome to SuperDuper Form!
        </p>
    </div>
    <div class="column">
        <div class="row-md-4">
            <h2>Vocab Program</h2>
            <p>
                This is a description about the vocabulary program.
            </p>

        </div>
        <div class="row-md-4">

            <br />
            <p>
                Enter the amount of vocabulary words you wish to study: 
                <br />
                <asp:TextBox ID="TextBox1" runat="server" Height="20px" Width="100px" AutoCompleteType="Disabled"></asp:TextBox>


            </p>
            <p>
                <asp:Button class="btn btn-default" ID="submitButton" runat="server" OnClick="submitButton_Click" Text="Submit" />
            </p>
            <br />
            <p>
                <asp:Panel ID="panel1" runat="server" EnableViewState="true"></asp:Panel>
            </p>
        </div>
        <div class="row-md-4">

            <p>
                <asp:Button class="btn btn-default" ID="saveButton" runat="server" text="Save List" OnClientClick="return true;" OnClick="saveButton_Click"/>
            </p>
            <br />
            <p>
                <asp:FileUpload class="btn btn-default" ID="vocabFileUpload" runat="server" />
                <br />
                <asp:Button class="btn btn-default" ID="importButton" runat="server" text="Import List" OnClientClick="return true;" OnClick="importButton_Click"/>
            </p>

        </div>
        <br />
        <br />
        <div class ="row-md-4">
            <asp:Button class="btn btn-default" ID="vocabTestButton" runat="server" Text="Take Test" OnClick="vocabTestButton_Click" />

            <asp:Button ID="reloadButton" runat="server" Text="Reload(Testing)" OnClientClick="return true;" />

        </div>
        <div class="row-md-4">
            <h2>Web Hosting</h2>
            <p>
                You can easily find a web hosting company that offers the right mix of features and price for your applications.
            </p>
            <p>
                <a class="btn btn-default" href="http://go.microsoft.com/fwlink/?LinkId=301950">Learn more &raquo;</a>
            </p>
        </div>
    </div>

</asp:Content>
