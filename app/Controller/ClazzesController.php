<?php
App::uses('AppController', 'Controller');
/**
 * Clazzes Controller
 *
 * @property Clazze $Clazze
 * @property PaginatorComponent $Paginator
 */
class ClazzesController extends AppController {

        public $name = 'Clazzes';
    
/**
 * Components
 *
 * @var array
 */
	public $components = array(
            'Paginator', 
            'Session',
            'Flash'
            );

/**
 * index method
 *
 * @return void
 */
	public function index() {
		$this->Clazze->recursive = 0;
		$this->set('clazzes', $this->Paginator->paginate());
	}

/**
 * view method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function view($id = null) {
		if (!$this->Clazze->exists($id)) {
			throw new NotFoundException(__('Invalid clazze'));
		}
		$options = array('conditions' => array('Clazze.' . $this->Clazze->primaryKey => $id));
		$this->set('clazze', $this->Clazze->find('first', $options));
	}

/**
 * add method
 *
 * @return void
 */
	public function add() {
		if ($this->request->is('post')) {
			$this->Clazze->create();
			if ($this->Clazze->save($this->request->data)) {
				$this->Flash->success(__('The clazze has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The clazze could not be saved. Please, try again.'));
			}
		}
		$this->setKeys();
	}
        
        protected function setKeys() {
            $carreiras = $this->Clazze->Carreira->find('list', array('fields' => 'Carreira.nome', 'Carreira.id'));
            $this->set(compact('carreiras'));
        }

/**
 * edit method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function edit($id = null) {
		if (!$this->Clazze->exists($id)) {
			throw new NotFoundException(__('Invalid clazze'));
		}
		if ($this->request->is(array('post', 'put'))) {
			if ($this->Clazze->save($this->request->data)) {
				$this->Flash->success(__('The clazze has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The clazze could not be saved. Please, try again.'));
			}
		} else {
			$options = array('conditions' => array('Clazze.' . $this->Clazze->primaryKey => $id));
			$this->request->data = $this->Clazze->find('first', $options);
		}
		$this->setKeys();
	}

/**
 * delete method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function delete($id = null) {
		$this->Clazze->id = $id;
		if (!$this->Clazze->exists()) {
			throw new NotFoundException(__('Invalid clazze'));
		}
		$this->request->allowMethod('post', 'delete');
		if ($this->Clazze->delete()) {
			$this->Flash->success(__('The clazze has been deleted.'));
		} else {
			$this->Flash->error(__('The clazze could not be deleted. Please, try again.'));
		}
		return $this->redirect(array('action' => 'index'));
	}
}
