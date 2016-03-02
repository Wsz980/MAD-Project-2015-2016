<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Downloads.aspx.cs" Inherits="WebAppTest1.WebForm3" %>


<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <div class="column">
        <div class="row-md-4">
            <h2>Downloads</h2>
            <h4 style="color: red;">NOTE: This downloads page uses HTML elements that are not supported on Internet Explorer and Safari browsers. In order to download the programs, please use Google Chrome, Firefox, Opera, or Microsoft Edge.</h4>
            <p>
                On this page you will find downloads to all of the programs provided on this website for offline use.
                <br />
                Click the link that corresponds with the program you wish to download. When the download completes, you should find it in the "Downloads" folder on your computer.
                <br />
                <br />
                It is important to note that these files are downloaded as .zip archives, and hence you will require a program such as WinZip or 7Zip to extract the files assuming
                your computer cannot do so itself.
            </p>
        </div>
        <br />
        <div class="row-md-4">
            <p>
                <a href="/JavaApplets/DayToDate.zip">
                    <%--<button class="btn btn-default" id="downloadA" runat="server">Download A</button>--%>
                    <font size="4">Day to Date</font>
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/JavaApplets/Stems.zip">
                    <font size="4">STEMS BROKEN</font>
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/JavaApplets/StatCapi.zip">
                    <font size="4">States and Capitals BROKEN</font>
                </a>
            </p>
        </div>
    </div>
</asp:Content>

