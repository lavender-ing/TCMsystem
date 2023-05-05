import moment from "moment"

function format(dateStr){
  return moment(dateStr).format("YYYY-MM-DD HH:mm:ss")
}

export default{
  format
}