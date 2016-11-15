<?php
App::uses('AppModel', 'Model');
/**
 * TipoIngresso Model
 *
 */
class TipoIngresso extends AppModel {

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
}
