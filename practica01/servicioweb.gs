const doGet = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Arnold', apellido = 'GetSchwarzenegger', tel = 200311233, dir = "Los Angeles" } = parameter;
    const salida = `Hola ${nombre} ${apellido} tu dirección es: ${dir} y tu telefono es: ${tel}`;
    return ContentService.createTextOutput(salida);
};

const doPost = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Arnold', apellido = 'PostSchwarzenegger', tel = 200311233, dir = "Los Angeles" } = parameter;
    const salida = `Hola ${nombre} ${apellido} tu dirección es: ${dir} y tu telefono es: ${tel}`;
    return ContentService.createTextOutput(salida);
};