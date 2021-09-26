$(document).ready(function() {
    $('#formLogin').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	nombre: {
                validators: {
                    notEmpty: {
                        message: 'Debe ingresar el nombre de usuario'
                    }
                }
            },
            clave: {
                validators: {
                    notEmpty: {
                        message: 'Debe ingresar la contraseña'
                    }
                }
            }
        }   
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#id_form').bootstrapValidator('validate');
    });
});