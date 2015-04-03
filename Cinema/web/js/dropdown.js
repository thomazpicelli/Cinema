$("#dropdown").on("click", function(e){
  e.preventDefault();
  
  if($(this).hasClass("open")) {
    $(this).removeClass("open");
    $(this).children("ul").slideUp("slow");
  } else {
    $(this).addClass("open");
    $(this).children("ul").slideDown("slow");
  }
});