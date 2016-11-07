<?php
App::uses('AppController', 'Controller');
/**
 * Pessoas Controller
 *
 * @property Pessoa $Pessoa
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 * @property SessionComponent $Session
 * @property FlashComponent $Flash
 */
class PessoasController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session', 'Flash');

	public $paginator_settings = array(
		'limit' => 10
		);

/**
 * index method
 *
 * @return void
 */
	public function index() {
		$this->Pessoa->recursive = 0;
		$this->Paginator->settings = $this->paginator_settings;
		$this->set('pessoas', $this->Paginator->paginate());
	}

/**
 * view method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function view($id = null) {
		if (!$this->Pessoa->exists($id)) {
			throw new NotFoundException(__('Invalid pessoa'));
		}
		$options = array('conditions' => array('Pessoa.' . $this->Pessoa->primaryKey => $id));
		$this->set('pessoa', $this->Pessoa->find('first', $options));
	}

/**
 * add method
 *
 * @return void
 */
	public function add() {
		if ($this->request->is('post')) {
			$this->Pessoa->create();
			if ($this->Pessoa->save($this->request->data)) {
				$this->Flash->success(__('The pessoa has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The pessoa could not be saved. Please, try again.'));
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
		if (!$this->Pessoa->exists($id)) {
			throw new NotFoundException(__('Invalid pessoa'));
		}
		if ($this->request->is(array('post', 'put'))) {
			if ($this->Pessoa->save($this->request->data)) {
				$this->Flash->success(__('The pessoa has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The pessoa could not be saved. Please, try again.'));
			}
		} else {
			$options = array('conditions' => array('Pessoa.' . $this->Pessoa->primaryKey => $id));
			$this->request->data = $this->Pessoa->find('first', $options);
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
		$this->Pessoa->id = $id;
		if (!$this->Pessoa->exists()) {
			throw new NotFoundException(__('Invalid pessoa'));
		}
		$this->request->allowMethod('post', 'delete');
		if ($this->Pessoa->delete()) {
			$this->Flash->success(__('The pessoa has been deleted.'));
		} else {
			$this->Flash->error(__('The pessoa could not be deleted. Please, try again.'));
		}
		return $this->redirect(array('action' => 'index'));
	}
}
