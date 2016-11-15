<?php

App::uses('AppModel', 'Model');

/**
 * Cta Model
 *
 * @property Funcionario $Funcionario
 */
class Cta extends AppModel {
    // The Associations below have been created with all possible keys, those that are not needed can be removed

    /**
     * belongsTo associations
     *
     * @var array
     */
    public $belongsTo = array(
        'Funcionario' => array(
            'className' => 'Funcionario'
        )
    );

}
