<div class="vagas form">
<?php echo $this->Form->create('Vaga'); ?>
	<fieldset>
		<legend><?php echo __('Edit Vaga'); ?></legend>
	<?php
		echo $this->Form->input('id');
		echo $this->Form->input('designacao');
		echo $this->Form->input('concurso_id');
		echo $this->Form->input('carreira_id');
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $this->Form->value('Vaga.id')), array('confirm' => __('Are you sure you want to delete # %s?', $this->Form->value('Vaga.id')))); ?></li>
		<li><?php echo $this->Html->link(__('List Vagas'), array('action' => 'index')); ?></li>
		<li><?php echo $this->Html->link(__('List Concursos'), array('controller' => 'concursos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Concurso'), array('controller' => 'concursos', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('controller' => 'carreiras', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('controller' => 'carreiras', 'action' => 'add')); ?> </li>
	</ul>
</div>
