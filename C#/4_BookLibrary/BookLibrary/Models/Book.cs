using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BookLibrary.Models                 //all
{
    public class Book
    {
        [Required]
        public int Id { get; set; }
        [Required]
        public string Title { get; set; }
        [Required]
        public string Describtion { get; set; }
        [Required]
        public string AuthorId { get; set; }
        public ApplicationUser Author { get; set; }
    }
}