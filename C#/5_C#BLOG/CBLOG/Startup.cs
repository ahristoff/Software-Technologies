using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(CBLOG.Startup))]
namespace CBLOG
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
