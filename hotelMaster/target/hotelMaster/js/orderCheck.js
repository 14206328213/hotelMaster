function check() {
    var total=0;
    var table=document.getElementById("itemTable");
    var day=$("#day").val();
    day=parseInt(day);
    var dc=$("#dc").text();
    var idc=dc.indexOf("元");
    dc=parseFloat(dc.substring(0,idc));
    var sum=dc*day;
    for(var i=1;i<table.rows.length;i++){
        var num=table.rows[i].getElementsByTagName("input")[0].value;
        num=parseInt(num);
        var p=table.rows[i].cells[1].innerHTML;
        var indx=p.indexOf("元");
        p=parseFloat(p.substring(0,indx));
        table.rows[i].cells[3].innerHTML=p*num+"元";
        total=total+p*num;
    }
    total+=sum;
    $("#sum").val(total);
    $("#end").css({"display":"block"});
    $("#check").css({"display":"none"});
}

function pay(ono) {
    var total=document.getElementById(ono).getElementsByTagName("td")[2].innerText;
    var bargain=document.getElementById(ono).getElementsByTagName("td")[3].innerText;
    total=parseFloat(total);
    bargain=parseFloat(bargain);
    console.log(total);
    console.log(bargain);
    var pay=total-bargain;
    if(confirm("您确定要付清"+pay+"元吗")==true){
        window.location.href="/pay.do?ono="+ono;
    }

}