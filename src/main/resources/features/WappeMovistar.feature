Feature: Flujo Nuevo RRAA Movistar Wappe
  _Feature para automatizar flujo

  @RRAAMovistar
  Scenario Outline: Nuevo RR.AA- agente
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    And Selecciona una empresa "<caso_de_prueba>" y opcion añadir RRAA
    And Ingresa datos solicitados del nuevo agente "<caso_de_prueba>"
    Then Usuario da clic en boton Confirmar Registro
    And Verifica la creacion del nuevo RRAA
    Examples:
      | login | caso_de_prueba |
      |    1  | 1             |
