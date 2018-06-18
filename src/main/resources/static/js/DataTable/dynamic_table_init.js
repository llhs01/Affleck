function fnFormatDetails ( oTable, nTr )
{
    var aData = oTable.fnGetData( nTr );
    var openId = aData[1];
    var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
    sOut += '<thead><tr><th>&nbsp;&nbsp;&nbsp;</th><th width="150px">卡号</th>';
    sOut += '<th width="150px">电话号码</th>';
    sOut += '<th width="150px">城市</th></tr></thead>';

    var html="";
    $.ajax({
        type:"get",
        url:mainpath+"/wxperson/getCardList",
        data:{openId:openId},
        async:false,
        success:function(data){
            var list = data.response.list;
            if(list.binding != 2){
                for(var i=0;i<list.length;i++){
                    html += "<tr><td>&nbsp;&nbsp;&nbsp;</td><td>"+list[i].cardId+"</td><td>"+list[i].phone+"</td><td>"+list[i].city+"</td></tr>";
                }
            }

        }
    });
    sOut +=html;
    sOut += "</table>";
    return sOut;
}

$(document).ready(function() {

    $('#dynamic-table').dataTable( {
        "aaSorting": [[ 4, "desc" ]]
    } );

    /*
     * Insert a 'details' column to the table
     */
    var nCloneTh = document.createElement( 'th' );
    var nCloneTd = document.createElement( 'td' );
    nCloneTd.innerHTML = '<img src="/static/img/details_open.png"/>';
    nCloneTd.className = "center";

    $('#hidden-table-info thead tr').each( function () {
        this.insertBefore( nCloneTh, this.childNodes[0] );
    } );

    $('#hidden-table-info tbody tr').each( function () {
        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
    } );

    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#hidden-table-info').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] }
        ],
        "aaSorting": [[1, 'asc']]
    });

    /* Add event listener for opening and closing details
     * Note that the indicator for showing which row is open is not controlled by DataTables,
     * rather it is done here
     */
    $(document).on('click','#hidden-table-info tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        if ( oTable.fnIsOpen(nTr) )
        {
            /* This row is already open - close it */
            this.src = "/static/img/details_open.png";
            oTable.fnClose( nTr );
        }
        else
        {
            /* Open this row */
            this.src = "/static/img/details_close.png";
            oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
        }
    } );
} );