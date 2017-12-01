$( document ).ready( main );

/* Contact form validation */
$.validator.setDefaults( {
		submitHandler: function () {
		alert( "submitted!" );
	}
} );
/* display image text about on click details */
function main() {

    $('.btn-collapse').click(function(e) {
        e.preventDefault();
        var $this = $(this);
        var $collapse = $this.closest('.collapse-group').find('.collapse');
        $collapse.collapse('toggle');
    });
    
    /* Contact form validation */
   /* $( "contactForm" ).validate( {
    		rules: {
    			email:
    				required: true,
    				email: true
    			},
    			firstName: {
    				required: true,
    				minlength: 2  				
    			},
    			lastName: {
    				required: true,
    				minlength: 5
    			},
			feedback: {
				required: true,
				minlength: 20
			}
    		},
    		messages: {
    			email: "Please enter a valid email address",
    			firstName: {
				required: "Please your firstName",
				minlength: "Your firstName must consist of at least 2 characters"
			},
			lastName: {
				required: "Please your lastName",
				minlength: "Your lastName must consist of at least 2 characters"
			},
			feedback: {
				required: "Please your feeback",
				minlength: "Your feedback must consist of at least 20 characters"
			}
    		},
			errorElement: "em",
			errorPlacement: function ( error, element ) {
				// Add the `help-block` class to the error element
				error.addClass( "help-block" );
			},
			highlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
			},
			unhighlight: function (element, errorClass, validClass) {
				$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
			}
    } );*/
    
    
    $('#contactForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            },
            firstName: {
                validators: {
                    notEmpty: {
                        message: 'The first name is required'
                    }
                }
            },
            lastName: {
                validators: {
                    notEmpty: {
                        message: 'The last name is required'
                    }
                }
            },
            feedback: {
                validators: {
                    notEmpty: {
                        message: 'Your feedback is valued and required'
                    }
                }
            }
        }
    });*/

    /* Forgot password form validation */
    $('#forgotPasswordForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            }
        }
    });

    $('#savePasswordForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: 'The password and its confirmation are not the same'
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: 'The confirmation password is required'
                    },
                    identical: {
                        field: 'password',
                        message: 'The password and its confirmation are not the same'
                    }
                }
            }
        }
    });

    /* Login page form validation */
    $('#loginForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            }
        }
    });

    /* Signup form validation */
    $('#signupForm').formValidation({
            framework: 'bootstrap',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                email: {
                    validators: {
                        notEmpty: {
                            message: 'The email is required'
                        },
                        emailAddress: {
                            message: 'The input is not a valid email address'
                        }
                    }
                },
                username: {
                    validators: {
                        notEmpty: {
                            message: 'The username is required'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required'
                        },
                        identical: {
                            field: 'confirmPassword',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: 'The confirmation password is required'
                        },
                        identical: {
                            field: 'password',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                },
                firstName: {
                    validators: {
                        notEmpty: {
                            message: 'The first name is required'
                        }
                    }
                },
                lastName: {
                    validators: {
                        notEmpty: {
                            message: 'The last name is required'
                        }
                    }
                },
                description: {
                    validators: {
                        stringLength: {
                            message: 'Post content must be less than 300 characters',
                            min: 0,
                            max: function (value, validator, $field) {
                                return 300 - (value.match(/\r/g) || []).length;
                            }
                        }
                    }
                },
                phoneNumber: {
                    validators: {
                        notEmpty: {
                            message: 'The phone number is required'
                        },
                        phone: {
                            country: 'country',
                            message: 'The value is not valid %s phone number'
                        }
                    }
                },
                cardNumber: {
                    validators: {
                        notEmpty: {
                            message: 'The credit card number is required'
                        },
                        creditCard: {
                            message: 'The credit card number is not valid'
                        }
                    }
                },
                cardCode: {
                    validators: {
                        notEmpty: {
                            message: 'The CVV number is required'
                        },
                        cardCode: {
                            creditCardField: 'cardNumber',
                            message: 'The CVV number is not valid'
                        }
                    }
                }
            }
        })
        // Revalidate phone number when changing the country
        .on('change', '[name="country"]', function(e) {
            $('#signupForm').formValidation('revalidateField', 'phoneNumber');
        });
}