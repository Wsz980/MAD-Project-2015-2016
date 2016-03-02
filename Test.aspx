<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Test.aspx.cs" Inherits="WebAppTest1.WebForm1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">


    <div class="column">
        <div class="row-md-4">
            <h2>Vocbulary Test</h2>
            <p>
                This is a description about the vocabulary test.
            </p>

        </div>
        <div class="row-md-4">


            <asp:Button class="btn btn-default" ID="showWords" runat="server" Text="Show Words" OnClick="showWords_Click" />
            &nbsp;&nbsp;
            <asp:Button class="btn btn-default" ID="showDefinitions" runat="server" Text="Show Definitions" OnClick="showDefinitions_Click" />

        </div>
        <br />
        <div class="row-md-4">

            <p>
                <asp:Panel ID="testPanel" runat="server">
                </asp:Panel>
                &nbsp;
            </p>

        </div>
        <div>

            <asp:Button class="btn btn-default" ID="submitTestButton" runat="server" Text="Submit Test" OnClick="submitTestButton_Click" />

            &nbsp;&nbsp;&nbsp;&nbsp;
            
            <asp:Button class="btn btn-default" ID="testAgainButton" runat="server" Text="Take Again" OnClientClick="return true" OnClick="testAgainButton_Click" />

        </div>
    </div>
</asp:Content>
