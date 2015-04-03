function Tempo(){
    horario = new Date()
    hora = horario.getHours()
    minuto = horario.getMinutes()
    segundo = horario.getSeconds()
    if (hora < 10) {
      hora = "0" + hora
    }
    if (minuto < 10) {
      minuto = "0" + minuto
    }
    if (segundo < 10) {
      segundo = "0" + segundo
    }
    document.getElementById("lugar").innerHTML = hora + ":" + minuto + ":" + segundo;         
}
window.setInterval("Tempo()", 1000)
