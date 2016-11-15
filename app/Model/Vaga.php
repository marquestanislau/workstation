<?php
App::uses('AppModel', 'Model');
/**
 * Vaga Model
 *
 * @property Concurso $Concurso
 * @property Carreira $Carreira
 */
class Vaga extends AppModel {

/**
 * Validation rules
 *
 * @var array
 */
	public $validate = array(
		'designacao' => array(
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
		'Concurso' => array(
			'className' => 'Concurso',
			'foreignKey' => 'concurso_id',
			'conditions' => '',
			'fields' => '',
			'order' => ''
		),
		'Carreira' => array(
			'className' => 'Carreira',
			'foreignKey' => 'carreira_id',
			'conditions' => '',
			'fields' => '',
			'order' => ''
		)
	);
}
