<div class="documentacaos form">
<?php echo $this->Form->create('Documentacao'); ?>
	<fieldset>
		<legend><?php echo __('Add Documentacao'); ?></legend>
	<?php
		echo $this->Form->input('nome');
		echo $this->Form->input('carreira_id', array('empty' => 'Selecione uma carreira'));
		echo $this->Form->input('concurso_id', array('empty' => 'Selecione um concurso '));
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Html->link(__('List Documentacaos'), array('action' => 'index')); ?></li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('controller' => 'carreiras', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('controller' => 'carreiras', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Concursos'), array('controller' => 'concursos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Concurso'), array('controller' => 'concursos', 'action' => 'add')); ?> </li>
	</ul>
</div>
