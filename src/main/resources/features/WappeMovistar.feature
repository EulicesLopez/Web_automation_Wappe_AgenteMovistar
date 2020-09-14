Feature: Flujo Nuevo RRAA Movistar Wappe
  _Feature para automatizar flujo

  @RRAAMovistar
  Scenario Outline: Nuevo RR.AA- agente
    Given Usuario se encuentra en la Web Wappe Agente
    When Completa datos de login y da click en el boton ingresar "<caso_de_prueba>"
    And Selecciona una empresa y opcion añadir RR.AA
    And Ingresa datos solicitados del nuevo agente "<caso_de_prueba>"
    Then Usuario da clic en boton Confirmar Registro
    And Verifica la creacion del nuevo RRAA
    Examples:
      | caso_de_prueba |
      | 1              |

  Web_automation_Wappe_AgenteMovistar