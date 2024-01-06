$(document).ready(function() {
  // Handle click event of "Detail" button
  $(document).on('click', '.open-modal', function() {
    // Get the invoice ID, date, and payment mode from the data attributes
    var invoiceId = $(this).data('invoiceid');
    var date = $(this).data('date');
    var payment = $(this).data('paymentmode');

    // Make an AJAX request to retrieve the invoice lines
    $.ajax({
      url: 'InvoiceLineList',
      type: 'POST',
      data: {
        invoiceId: invoiceId,
        date: date,
        payment: payment
      },
      success: function(response) {
        // Log the response received from the servlet
        console.log(response);

        // Update the modal body with the retrieved data
        $('#invoiceLineModalBody').html(response);

        // Open the modal
        $('#exampleModal').modal('show');
      },
      error: function() {
        alert('An error occurred while retrieving invoice lines.');
      }
    });
  });
});
