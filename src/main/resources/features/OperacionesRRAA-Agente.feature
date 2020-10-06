Feature: Flujos de operaciones con RRAA
  _Feature para automatizar flujo

  @AñadirNuevoRRAA-Agente
   Scenario Outline: Nuevo RR.AA- agente
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    And Selecciona una empresa "<caso_de_prueba>" y opcion añadir RRAA
    And Ingresa datos solicitados del nuevo agente "<caso_de_prueba>"
    Then Usuario selecciona RRAA "<caso_de_prueba>" y se asigna un rol online "<caso_de_prueba>"
    And Verifica la Certificacion del nuevo RRAA "<caso_de_prueba>"
    Examples:
      | login | caso_de_prueba |
      | 1     | 1              |


  @EliminarRRAA-Agente
  Scenario Outline: Eliminar un usuario RRAA-Agente
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    And Selecciona una empresa "<caso_de_prueba>" y selecciona un usuario "<caso_de_prueba>"
    Then Usuario da clic en el icono Eliminar y se valida el registo eliminado
    Examples:
      | login | caso_de_prueba |
      | 1     | 1              |


  @EditarRRAA-Agente
  Scenario Outline: Editar un usuario RRAA-Agente
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    And Selecciona una empresa "<caso_de_prueba>" y selecciona el usuario "<caso_de_prueba>" a editar
    Then Usuario ingresa los datos a editar "<caso_de_prueba>"
    Then Usuario da clic en boton Actualizar y valida registro editado
    Examples:
      | login | caso_de_prueba |
      | 1     | 1              |