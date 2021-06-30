var collapsible = document.querySelectorAll(".collapsible > button")
var i;

for (i = 0; i < collapsible.length; i++) {
    collapsible[i].addEventListener("click", function () {
        var content = this.nextElementSibling;
        while(content){
                content.classList.toggle("active");
                content = content.nextElementSibling;
        }
    })
}