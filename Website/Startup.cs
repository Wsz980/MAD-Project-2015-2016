using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(WebAppTest1.Startup))]
namespace WebAppTest1
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
