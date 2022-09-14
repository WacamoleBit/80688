const doGet = (e = {}) => {
  const { parameter } = e;
  const { nombre = 'Vlad', apellido = 'GetTepes', tel = 2203112313, dir = "Los Angeles" } = parameter;
  const salida = `Hola ${nombre} ${apellido} tu dirección es: ${dir} y tu telefono es: ${tel}`;
  return ContentService.createTextOutput(salida);
};

const doPost = (e = {}) => {
  const { parameter } = e;
  const { nombre = 'Vlad', apellido = 'PostTepes', tel = 2203112313, dir = "Los Angeles" } = parameter;
  const salida = `Hola ${nombre} ${apellido} tu dirección es: ${dir} y tu telefono es: ${tel}`;
  return ContentService.createTextOutput(salida);
};