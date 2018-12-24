using CBLOG.Models;
using Microsoft.AspNet.Identity;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CBLOG.Controllers
{
    public class ArticleController : Controller      //all
    {
        public ActionResult List()
        {
            using (var db = new BlogDbContext())
            {
                var articles = db.Articles
                    .Include(a => a.Author)
                    .ToList();

                return View(articles);
            }
            
        }

        [HttpGet]
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Authorize]
        public ActionResult Create(Article model)
        {
            if (ModelState.IsValid)
            {
                using (var db = new BlogDbContext())
                {
                    var authorId = User.Identity.GetUserId();

                    model.AuthorId = authorId;

                    db.Articles.Add(model);
                    db.SaveChanges();
                }

                return RedirectToAction("List");
            }
            return View(model);
        }

        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles
                    .Include(a => a.Author)
                    .Where(a => a.Id == id)
                    .FirstOrDefault();

                if (article == null)
                {
                    return HttpNotFound();
                }

                return View(article);
            }
        }
        [HttpGet]
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles
                    .Include(a => a.Author)
                    .Where(a => a.Id == id)
                    .FirstOrDefault();

                if (! IsUserAuthorizedToEdit(article)) //za validazia
                {
                    return new HttpStatusCodeResult(System.Net.HttpStatusCode.Forbidden);
                }

                if (article == null )//|| !IsAuthorize(article)) //2 za validazia
                {
                    return HttpNotFound();
                }

                return View(article);
            }
        }

       

        [HttpPost]
        [Authorize]
        [ActionName("Delete")]
        public ActionResult ConfirmDelete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles
                    .Include(a => a.Author)
                    .Where(a => a.Id == id)
                    .FirstOrDefault();

                if (article == null)
                {
                    return HttpNotFound();
                }

                db.Articles.Remove(article);
                db.SaveChanges();



                return RedirectToAction("List");
            }

        }

        [HttpGet]
        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles
                    .Where(a => a.Id == id)
                    .FirstOrDefault();

                if (!IsUserAuthorizedToEdit(article)) //za validazia
                {
                    return new HttpStatusCodeResult(System.Net.HttpStatusCode.Forbidden);
                }

                if (article == null)//|| !IsAuthorize(article)) //2 za validazia
                {
                    return HttpNotFound();
                }

                var articleViewModel = new ArticleViewModel
                {
                    Id = article.Id,
                    Title = article.Title,
                    Content = article.Content,
                    AuthorId = article.AuthorId
                };

                return View(articleViewModel);
            }
        }

        [HttpPost]
        [Authorize]
        public ActionResult Edit(ArticleViewModel model)
        {
            if (ModelState.IsValid)
            {
                using (var db = new BlogDbContext())
                {
                    var article = db.Articles.Find(model.Id);  //vzemi go ot BD
                    article.Title = model.Title;               //promiana za Title
                    article.Content = model.Content;           // promiana za Content

                    db.SaveChanges();

                }

                return RedirectToAction("Details", new { id = model.Id });

            }
            return View(model);

        }

        private bool IsUserAuthorizedToEdit(Article article)  // za validizia
        {
            var isAdmin = this.User.IsInRole("Admin");
            var isAuthor = article.IsAuthor(this.User.Identity.GetUserId());

            return isAdmin || isAuthor;
        }

    }
}