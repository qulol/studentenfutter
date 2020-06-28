function printShoppingList() {
        var printWindow = window.open();

        printWindow.document.write('<html><head><title>' + document.title  + '</title>');
        printWindow.document.write('</head><body >');
        printWindow.document.write('<h1>' + document.title  + '</h1>');
        printWindow.document.write(document.getElementById("toPrint").innerHTML);
        printWindow.document.write('</body></html>');

        printWindow.document.close(); // necessary for IE >= 10
        printWindow.focus(); // necessary for IE >= 10

        printWindow.print();
        printWindow.close();
}