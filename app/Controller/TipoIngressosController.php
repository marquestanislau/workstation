<?php
App::uses('AppController', 'Controller');
/**
 * TipoIngressos Controller
 *
 * @property TipoIngresso $TipoIngresso
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 * @property FlashComponent $Flash
 */
class TipoIngressosController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session', 'Flash');

/**
 * index method
 *
 * @return void
 */
	public function index() {
		$this->TipoIngresso->recursive = 0;
		$this->set('tipoIngressos', $this->Paginator->paginate());
	}

/**
 * view method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function view($id = null) {
		if (!$this->TipoIngresso->exists($id)) {
			throw new NotFoundException(__('Invalid tipo ingresso'));
		}
		$options = array('conditions' => array('TipoIngresso.' . $this->TipoIngresso->primaryKey => $id));
		$this->set('tipoIngresso', $this->TipoIngresso->find('first', $options));
	}

/**
 * add method
 *
 * @return void
 */
	public function add() {
		if ($this->request->is('post')) {
			$this->TipoIngresso->create();
			if ($this->TipoIngresso->save($this->request->data)) {
				$this->Flash->success(__('The tipo ingresso has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The tipo ingresso could not be saved. Please, try again.'));
			}
		}
	}

/**
 * edit method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function edit($id = null) {
		if (!$this->TipoIngresso->exists($id)) {
			throw new NotFoundException(__('Invalid tipo ingresso'));
		}
		if ($this->request->is(array('post', 'put'))) {
			if ($this->TipoIngresso->save($this->request->data)) {
				$this->Flash->success(__('The tipo ingresso has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The tipo ingresso could not be saved. Please, try again.'));
			}
		} else {
			$options = array('conditions' => array('TipoIngresso.' . $this->TipoIngresso->primaryKey => $id));
			$this->request->data = $this->TipoIngresso->find('first', $options);
		}
	}

/**
 * delete method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function delete($id = null) {
		$this->TipoIngresso->id = $id;
		if (!$this->TipoIngresso->exists()) {
			throw new NotFoundException(__('Invalid tipo ingresso'));
		}
		$this->request->allowMethod('post', 'delete');
		if ($this->TipoIngresso->delete()) {
			$this->Flash->success(__('The tipo ingresso has been deleted.'));
		} else {
			$this->Flash->error(__('The tipo ingresso could not be deleted. Please, try again.'));
		}
		return $this->redirect(array('action' => 'index'));
	}
}
