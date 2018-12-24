using BookLibrary.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;
using Microsoft.AspNet.Identity;

namespace BookLibrary.Controllers
{
    public class BookController : Controller
    {
        // GET: Book
        public ActionResult Index()                       //  all
        {
            using (var db = new ApplicationDbContext()) //
            {
                var books = db.Books.Include(b =>b.Author).ToList();        //

                return View(books);                  //
            }
        }

        // GET: Book/Details/5
        public ActionResult Details(int id)     //all
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Include(b => b.Author).SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult();
                }
                return View(book);
            }
               
        }

        // GET: Book/Create
        [Authorize]
        public ActionResult Create()  //dava prasna forma
        {
            return View();
        }

        // POST: Book/Create
        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]                       //all action
        public ActionResult Create(Book book)   //dava populnenata forma
        {
            using (var db = new ApplicationDbContext())
            {
                var userId = User.Identity.GetUserId();

                book.AuthorId = userId;

                db.Books.Add(book);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
                
        }

        // GET: Book/Edit/5
        [Authorize]
        public ActionResult Edit(int id)         //all action
        {
            using (var db = new ApplicationDbContext())
            {


                var book = db.Books.SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult("cannot find this book");
                }

                if (book.AuthorId != User.Identity.GetUserId())
                {
                    return new HttpUnauthorizedResult("You cannot touch this book");
                }

                return View(book);
            }
        }

        // POST: Book/Edit/5
        [HttpPost]
        [Authorize]
        public ActionResult Edit(int id, Book bookViewModel)  //all action
        {
            if (bookViewModel.Title == null || bookViewModel.Describtion ==null)
            {
                return View(bookViewModel);
            }

            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.Include(b=>b.Author).SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult("cannot find this book");
                }

                if (book.AuthorId != User.Identity.GetUserId())
                {
                    return new HttpUnauthorizedResult("You cannot touch this book");
                }

                book.Title = bookViewModel.Title;
                book.Describtion = bookViewModel.Describtion;

                db.SaveChanges();
            }

                return RedirectToAction("Details", new { id = id });     //ako vsichko e ok otidi v details i mi podai id koeto sme edit
        }

        // GET: Book/Delete/5
        [Authorize]
        public ActionResult Delete(int id)         //all  action
        {
            using (var db = new ApplicationDbContext())
            {


                var book = db.Books.SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult("cannot find this book");
                }

                if (book.AuthorId != User.Identity.GetUserId())
                {
                    return new HttpUnauthorizedResult("You cannot touch this book");
                }

                return View(book);
            }
        }

        // POST: Book/Delete/5
        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, Book bookViewModel)   // all action
        {
            using (var db = new ApplicationDbContext())
            {
                var book = db.Books.SingleOrDefault(b => b.Id == id);

                if (book == null)
                {
                    return new HttpNotFoundResult("cannot find this book");
                }

                if (book.AuthorId != User.Identity.GetUserId())
                {
                    return new HttpUnauthorizedResult("You cannot touch this book");
                }

                db.Books.Remove(book);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
    }
}
