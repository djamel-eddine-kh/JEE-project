/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * $(document).ready(function() {
    const formSections = ["addArticleForm", "addInvoiceForm", "addClientForm", "ClientList"];
    const buttons = ["addArticleBtn", "addInvoiceBtn", "addClientBtn", "ClientListbtn"];

    // Hide all form sections initially
    formSections.forEach(section => $("#" + section).hide());

    // Show the selected form section based on button click
    buttons.forEach((button, index) => {
        $("#" + button).click(function() {
            formSections.forEach(section => $("#" + section).hide());
            $("#" + formSections[index]).show();

            if (button === "ClientListbtn") {
                // Make an AJAX request to fetch the client list and update the section content
                $.ajax({
                    url: "ClientList",
                    type: "GET",
                    success: function(response) {
                        $("#ClientList").html(response);
                    },
                    error: function() {
                        console.log("Error occurred while fetching client list.");
                    }
                });
            }
        });
    });
});



 $(document).ready(function() {
            // Hide all form sections initially
            $("#addArticleForm").hide();
            $("#addInvoiceForm").hide();
            $("#addClientForm").hide();
            $("#ClientList").hide();
            
            // Show the selected form section based on button click
            $("#addArticleBtn").click(function() {
                
                $("#addClientForm").hide();
                    $("#addInvoiceForm").hide;
                $("#ClientList").hide();
                 
                     $("#addArticleForm").show();
            });
            
            $("#addInvoiceBtn").click(function() {
                
                $("#addArticleForm").hide();
                $("#addClientForm").hide();
                 $("#ClientList").hide();
                 $("#addInvoiceForm").show();
            });
            
            $("#addClientBtn").click(function() {
                $("#addArticleForm").hide();
                $("#addInvoiceForm").hide();
                 $("#ClientList").hide();
                  $("#addClientForm").show();
            });
               $("#ClientListbtn").click(function() {
                $("#addArticleForm").hide();
                $("#addInvoiceForm").hide();
                $("#addClientForm").hide();
                 $("#ClientList").show();
            });
        });

 $(document).ready(function() {
  // Map button IDs to corresponding form section IDs
  var formSections = {
    "addArticleBtn": "addArticleForm",
    "addInvoiceBtn": "addInvoiceForm",
    "addClientBtn": "addClientForm",
    "ClientListbtn": "ClientList",
    "ArticleListbtn": "ArticleList",
    "InvoiceListbtn": "InvoiceList"
  };

  // Hide all form sections initially
  hideAllFormSections();

  // Show the selected form section based on button click
  $("button[id^='add']").click(function() {
    var sectionId = formSections[$(this).attr("id")];
    hideAllFormSections();
    $("#" + sectionId).show();
  });

  $("button[id$='Listbtn']").click(function() {
    var sectionId = formSections[$(this).attr("id")];
    hideAllFormSections();
    $("#" + sectionId).show();
  });
});

function hideAllFormSections() {
  $("div[id$='Form'], div[id$='List']").hide();
}

*/
    