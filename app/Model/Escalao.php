<?php
App::uses('AppModel', 'Model');
/**
 * Escalao Model
 *
 * @property Categoria $Categoria
 * @property Classe $Classe
 */
class Escalao extends AppModel {

/**
 * Validation rules
 *
 * @var array
 */
	public $validate = array(
		'nome' => array(
			'notBlank' => array(
				'rule' => array('notBlank'),
				//'message' => 'Your custom message here',
				//'allowEmpty' => false,
				//'required' => false,
				//'last' => false, // Stop validation after this rule
				//'on' => 'create', // Limit validation to 'create' or 'update' operations
			),
		),
	);

	// The Associations below have been created with all possible keys, those that are not needed can be removed

/**
 * belongsTo associations
 *
 * @var array
 */
	public $belongsTo = array(
		'Categoria' => array(
			'className' => 'Categoria',
			'foreignKey' => 'categoria_id',
			'conditions' => '',
			'fields' => '',
			'order' => ''
		),
		'Rclasse' => array(
			'className' => 'Rclasse',
			'foreignKey' => 'rclasse_id',
			'conditions' => '',
			'fields' => '',
			'order' => ''
		)
	);
}
